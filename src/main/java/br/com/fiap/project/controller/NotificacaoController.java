package br.com.fiap.project.controller;

import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.Notificacao;
import br.com.fiap.project.service.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<List<Notificacao>> getAllNotificacoes() {
        List<Notificacao> notificacoes = notificacaoService.getAllNotificacoes();
        if (notificacoes == null || notificacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se a lista estiver vazia
        }
        return ResponseEntity.ok(notificacoes); // Retorna 200 com a lista de notificações
    }

    @GetMapping("/{id_notificacao}")
    public ResponseEntity<Notificacao> getNotificacaoById(@PathVariable Integer id_notificacao) {
        Notificacao notificacao = notificacaoService.getNotificacaoById(id_notificacao);
        if (notificacao == null) {
            throw new ResourceNotFoundException("Nenhuma notificação encontrada com o id: " + id_notificacao);
        }
        return ResponseEntity.ok(notificacao); // Retorna 200 com a notificação encontrada
    }

    @PostMapping
    public ResponseEntity<?> createNotificacao(@Valid @RequestBody Notificacao notificacao, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 se houver erros de validação
        }
        Notificacao createdNotificacao = notificacaoService.createNotificacao(notificacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNotificacao); // Retorna 201 com o recurso criado
    }

    @PutMapping("/{id_notificacao}")
    public ResponseEntity<?> updateNotificacao(@PathVariable Integer id_notificacao, @Valid @RequestBody Notificacao notificacao, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 em caso de erros de validação
        }
        Notificacao updatedNotificacao = notificacaoService.updateNotificacao(id_notificacao, notificacao);
        if (updatedNotificacao == null) {
            throw new ResourceNotFoundException("Nenhuma notificação encontrada com o id: " + id_notificacao);
        }
        return ResponseEntity.ok(updatedNotificacao); // Retorna 200 com o objeto atualizado
    }

    @DeleteMapping("/{id_notificacao}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable Integer id_notificacao) {
        if (notificacaoService.existsById(id_notificacao)) {
            notificacaoService.deleteNotificacao(id_notificacao);
            return ResponseEntity.noContent().build(); // Retorna 204 sem corpo de resposta
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se o recurso não for encontrado
        }
    }
}

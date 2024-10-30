package br.com.fiap.project.controller;

import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.LogNotificacoes;
import br.com.fiap.project.service.LogNotificacoesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log-notificacoes")
public class LogNotificacoesController {

    @Autowired
    private LogNotificacoesService logNotificacoesService;

    @GetMapping
    public ResponseEntity<List<LogNotificacoes>> getAllLogNotificacoes() {
        List<LogNotificacoes> logNotificacoes = logNotificacoesService.getAllLogNotificacoes();
        if (logNotificacoes == null || logNotificacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se a lista estiver vazia
        }
        return ResponseEntity.ok(logNotificacoes); // Retorna 200 com a lista de logs de notificações
    }

    @GetMapping("/{id_log}")
    public ResponseEntity<LogNotificacoes> getLogNotificacoesById(@PathVariable Integer id_log) {
        LogNotificacoes logNotificacoes = logNotificacoesService.getLogNotificacoesById(id_log);
        if (logNotificacoes == null) {
            throw new ResourceNotFoundException("Não foi encontrado nenhum log com o id: " + id_log);
        }
        return ResponseEntity.ok(logNotificacoes); // Retorna 200 com o log encontrado
    }

    @PostMapping
    public ResponseEntity<?> createLogNotificacoes(@Valid @RequestBody LogNotificacoes logNotificacoes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 se houver erros de validação
        }
        LogNotificacoes createdLogNotificacoes = logNotificacoesService.createLogNotificacoes(logNotificacoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLogNotificacoes); // Retorna 201 com o recurso criado
    }

    @PutMapping("/{id_log}")
    public ResponseEntity<?> updateLogNotificacoes(@PathVariable Integer id_log, @Valid @RequestBody LogNotificacoes logNotificacoes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 em caso de erros de validação
        }
        LogNotificacoes updatedLogNotificacoes = logNotificacoesService.updateLogNotificacoes(id_log, logNotificacoes);
        if (updatedLogNotificacoes == null) {
            throw new ResourceNotFoundException("Não foi encontrado nenhum log com o id: " + id_log);
        }
        return ResponseEntity.ok(updatedLogNotificacoes); // Retorna 200 com o objeto atualizado
    }

    @DeleteMapping("/{id_log}")
    public ResponseEntity<Void> deleteLogNotificacoes(@PathVariable Integer id_log) {
        if (logNotificacoesService.existsById(id_log)) {
            logNotificacoesService.deleteLogNotificacoes(id_log);
            return ResponseEntity.noContent().build(); // Retorna 204 sem corpo de resposta
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se o recurso não for encontrado
        }
    }
}

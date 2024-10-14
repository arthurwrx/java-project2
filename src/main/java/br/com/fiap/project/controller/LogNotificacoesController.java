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
        return ResponseEntity.ok(logNotificacoes);
    }

    @GetMapping("/{id_log}")
    public ResponseEntity<LogNotificacoes> getLogNotificacoesById(@PathVariable Integer id_log) {
        LogNotificacoes logNotificacoes = logNotificacoesService.getLogNotificacoesById(id_log);
        if (logNotificacoes == null) {
            throw new ResourceNotFoundException("Não foi encontrado nenhum log com o id: " + id_log);
        }
        return ResponseEntity.ok(logNotificacoes);
    }

    @PostMapping
    public ResponseEntity<?> createLogNotificacoes(@Valid @RequestBody LogNotificacoes logNotificacoes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        LogNotificacoes createdLogNotificacoes = logNotificacoesService.createLogNotificacoes(logNotificacoes);
        return ResponseEntity.ok(createdLogNotificacoes);
    }

    @PutMapping("/{id_log}")
    public ResponseEntity<?> updateLogNotificacoes(@PathVariable Integer id_log, @Valid @RequestBody LogNotificacoes logNotificacoes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        LogNotificacoes updatedLogNotificacoes = logNotificacoesService.updateLogNotificacoes(id_log, logNotificacoes);
        if (updatedLogNotificacoes == null) {
            throw new ResourceNotFoundException("Não foi encontrado nenhum log com o id: " + id_log);
        }
        return ResponseEntity.ok(updatedLogNotificacoes);
    }

    @DeleteMapping("/{id_log}")
    public ResponseEntity<String> deleteLogNotificacoes(@PathVariable Integer id_log) {
        if (logNotificacoesService.existsById(id_log)) {
            logNotificacoesService.deleteLogNotificacoes(id_log);
            return ResponseEntity.ok("Log deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Log com o ID " + id_log + " não foi encontrado.");
        }
    }
}

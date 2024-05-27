package br.com.fiap.project.controller;

import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.DiaColeta;
import br.com.fiap.project.service.DiaColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dia-coleta")
public class DiaColetaController {

    @Autowired
    private DiaColetaService diaColetaService;

    @Autowired
    private Environment environment;

    @GetMapping("/porta")
    public ResponseEntity<String> exibirPorta() {
        String porta = environment.getProperty("local.server.port");
        String mensagem = String.format("PORTA UTILIZADA NA REQUISIÇÃO: %s", porta);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping
    public ResponseEntity<List<DiaColeta>> getAllDiasColeta() {
        List<DiaColeta> diaColetas = diaColetaService.getAllDiasColeta();
        return ResponseEntity.ok(diaColetas);
    }

    @GetMapping("/{id_dia_coleta}")
    public ResponseEntity<DiaColeta> getDiaColetaById(@PathVariable Integer id_dia_coleta) {
        DiaColeta diaColeta = diaColetaService.getDiaColetaById(id_dia_coleta);
        if (diaColeta == null) {
            throw new ResourceNotFoundException("Dia de coleta não encontrada, o id " + id_dia_coleta + " está incorreto");
        }
        return ResponseEntity.ok(diaColeta);
    }

    @PostMapping
    public ResponseEntity<?> createDiaColeta(@Valid @RequestBody DiaColeta diaColeta, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        DiaColeta createdDiaColeta = diaColetaService.createDiaColeta(diaColeta);
        return ResponseEntity.ok(createdDiaColeta);
    }

    @PutMapping("/{id_dia_coleta}")
    public ResponseEntity<?> updateDiaColeta(@PathVariable Integer id_dia_coleta, @Valid @RequestBody DiaColeta diaColeta, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        DiaColeta updatedDiaColeta = diaColetaService.updateDiaColeta(id_dia_coleta, diaColeta);
        if (updatedDiaColeta == null) {
            throw new ResourceNotFoundException("Dia de coleta não encontrada, o id " + id_dia_coleta + " está incorreto");
        }
        return ResponseEntity.ok(updatedDiaColeta);
    }

    @DeleteMapping("/{id_dia_coleta}")
    public ResponseEntity<String> deleteDiaColeta(@PathVariable Integer id_dia_coleta) {
        if (diaColetaService.existsById(id_dia_coleta)) {
            diaColetaService.deleteDiaColeta(id_dia_coleta);
            return ResponseEntity.ok("Dia de coleta deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dia da coleta com o ID " + id_dia_coleta + " não foi encontrado.");
        }
    }
}

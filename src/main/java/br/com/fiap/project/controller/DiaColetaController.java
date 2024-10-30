package br.com.fiap.project.controller;

import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.DiaColeta;
import br.com.fiap.project.service.DiaColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dia-coleta")
public class DiaColetaController {

    @Autowired
    private DiaColetaService diaColetaService;

    @GetMapping
    public ResponseEntity<List<DiaColeta>> getAllDiasColeta() {
        List<DiaColeta> diaColetas = diaColetaService.getAllDiasColeta();
        if (diaColetas == null || diaColetas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se a lista estiver vazia
        }
        return ResponseEntity.ok(diaColetas); // Retorna 200 com a lista de dias de coleta
    }

    @GetMapping("/{id_dia_coleta}")
    public ResponseEntity<DiaColeta> getDiaColetaById(@PathVariable Integer id_dia_coleta) {
        DiaColeta diaColeta = diaColetaService.getDiaColetaById(id_dia_coleta);
        if (diaColeta == null) {
            throw new ResourceNotFoundException("Dia de coleta não encontrado, o id " + id_dia_coleta + " está incorreto");
        }
        return ResponseEntity.ok(diaColeta); // Retorna 200 com o dia de coleta encontrado
    }

    @PostMapping
    public ResponseEntity<?> createDiaColeta(@Valid @RequestBody DiaColeta diaColeta, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 se houver erros de validação
        }
        DiaColeta createdDiaColeta = diaColetaService.createDiaColeta(diaColeta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiaColeta); // Retorna 201 com o recurso criado
    }

    @PutMapping("/{id_dia_coleta}")
    public ResponseEntity<?> updateDiaColeta(@PathVariable Integer id_dia_coleta, @Valid @RequestBody DiaColeta diaColeta, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 em caso de erros de validação
        }
        DiaColeta updatedDiaColeta = diaColetaService.updateDiaColeta(id_dia_coleta, diaColeta);
        if (updatedDiaColeta == null) {
            throw new ResourceNotFoundException("Dia de coleta não encontrado, o id " + id_dia_coleta + " está incorreto");
        }
        return ResponseEntity.ok(updatedDiaColeta); // Retorna 200 com o objeto atualizado
    }

    @DeleteMapping("/{id_dia_coleta}")
    public ResponseEntity<Void> deleteDiaColeta(@PathVariable Integer id_dia_coleta) {
        if (diaColetaService.existsById(id_dia_coleta)) {
            diaColetaService.deleteDiaColeta(id_dia_coleta);
            return ResponseEntity.noContent().build(); // Retorna 204 sem corpo de resposta
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se o recurso não for encontrado
        }
    }
}

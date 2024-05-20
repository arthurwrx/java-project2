package br.com.fiap.project.controller;


import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.Morador;
import br.com.fiap.project.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/morador")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public ResponseEntity<List<Morador>> getAllMoradores() {
        List<Morador> moradores = moradorService.getAllMoradores();
        return ResponseEntity.ok(moradores);
    }

    @GetMapping("/{id_morador}")
    public ResponseEntity<Morador> getMoradorById(@PathVariable Integer id_morador) {
        Morador morador = moradorService.getMoradorById(id_morador);
        if (morador == null) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um morador com o id: " + id_morador);
        }
        return ResponseEntity.ok(morador);
    }

    @PostMapping
    public ResponseEntity<?> createMorador(@Valid @RequestBody Morador morador, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Morador createdMorador = moradorService.createMorador(morador);
        return ResponseEntity.ok(createdMorador);
    }

    @PutMapping("/{id_morador}")
    public ResponseEntity<?> updateMorador(@PathVariable Integer id_morador, @Valid @RequestBody Morador morador, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Morador updatedMorador = moradorService.updateMorador(id_morador, morador);
        if (updatedMorador == null) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um morador com o id: " + id_morador);
        }
        return ResponseEntity.ok(updatedMorador);
    }

    @DeleteMapping("/{id_morador}")
    public ResponseEntity<Void> deleteMorador(@PathVariable Integer id_morador) {
        if (!moradorService.existsById(id_morador)) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um morador com o id: " + id_morador);
        }
        moradorService.deleteMorador(id_morador);
        return ResponseEntity.noContent().build();
    }
}


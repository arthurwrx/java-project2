package br.com.fiap.project.controller;


import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.Morador;
import br.com.fiap.project.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> deleteMorador(@PathVariable Integer id_morador) {
        if (moradorService.existsById(id_morador)) {
            moradorService.deleteMorador(id_morador);
            return ResponseEntity.ok("Morador deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Morador com o ID " + id_morador + " não foi encontrado.");
        }
    }
}


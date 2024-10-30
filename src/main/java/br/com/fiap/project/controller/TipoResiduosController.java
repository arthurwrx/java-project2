package br.com.fiap.project.controller;

import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.TipoResiduos;
import br.com.fiap.project.service.TipoResiduosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-residuos")
public class TipoResiduosController {

    @Autowired
    private TipoResiduosService tipoResiduosService;

    @GetMapping
    public ResponseEntity<List<TipoResiduos>> getAllTipoResiduos() {
        List<TipoResiduos> tipoResiduosList = tipoResiduosService.getAllTipoResiduos();
        if (tipoResiduosList == null || tipoResiduosList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 se a lista estiver vazia
        }
        return ResponseEntity.ok(tipoResiduosList); // Retorna 200 com a lista de tipos de resíduos
    }

    @GetMapping("/{id_tipo_residuos}")
    public ResponseEntity<TipoResiduos> getTipoResiduosById(@PathVariable Integer id_tipo_residuos) {
        TipoResiduos tipoResiduos = tipoResiduosService.getTipoResiduosById(id_tipo_residuos);
        if (tipoResiduos == null) {
            throw new ResourceNotFoundException("Nenhum tipo de residuo foi encontrado com o id: " + id_tipo_residuos);
        }
        return ResponseEntity.ok(tipoResiduos); // Retorna 200 com o tipo de resíduo encontrado
    }

    @PostMapping
    public ResponseEntity<?> createTipoResiduos(@Valid @RequestBody TipoResiduos tipoResiduos, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 em caso de erros de validação
        }
        TipoResiduos createdTipoResiduos = tipoResiduosService.createTipoResiduos(tipoResiduos);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTipoResiduos); // Retorna 201 com o recurso criado
    }

    @PutMapping("/{id_tipo_residuos}")
    public ResponseEntity<?> updateTipoResiduos(@PathVariable Integer id_tipo_residuos, @Valid @RequestBody TipoResiduos tipoResiduos, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors()); // Retorna 400 em caso de erros de validação
        }
        TipoResiduos updatedTipoResiduos = tipoResiduosService.updateTipoResiduos(id_tipo_residuos, tipoResiduos);
        if (updatedTipoResiduos == null) {
            throw new ResourceNotFoundException("Nenhum tipo de residuo foi encontrado com o id: " + id_tipo_residuos);
        }
        return ResponseEntity.ok(updatedTipoResiduos); // Retorna 200 com o objeto atualizado
    }

    @DeleteMapping("/{id_tipo_residuos}")
    public ResponseEntity<Void> deleteTipoResiduos(@PathVariable Integer id_tipo_residuos) {
        if (tipoResiduosService.existsById(id_tipo_residuos)) {
            tipoResiduosService.deleteTipoResiduos(id_tipo_residuos);
            return ResponseEntity.noContent().build(); // Retorna 204 sem corpo de resposta
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se o recurso não for encontrado
        }
    }
}

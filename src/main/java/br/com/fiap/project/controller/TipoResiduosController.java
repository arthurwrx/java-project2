package br.com.fiap.project.controller;

import br.com.fiap.project.exception.ResourceNotFoundException;
import br.com.fiap.project.model.TipoResiduos;
import br.com.fiap.project.service.TipoResiduosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment environment;

    @GetMapping("/porta")
    public ResponseEntity<String> exibirPorta() {
        String porta = environment.getProperty("local.server.port");
        String mensagem = String.format("PORTA UTILIZADA NA REQUISIÇÃO: %s", porta);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping
    public ResponseEntity<List<TipoResiduos>> getAllTipoResiduos() {
        List<TipoResiduos> tipoResiduosList = tipoResiduosService.getAllTipoResiduos();
        return ResponseEntity.ok(tipoResiduosList);
    }

    @GetMapping("/{id_tipo_residuos}")
    public ResponseEntity<TipoResiduos> getTipoResiduosById(@PathVariable Integer id_tipo_residuos) {
        TipoResiduos tipoResiduos = tipoResiduosService.getTipoResiduosById(id_tipo_residuos);
        if (tipoResiduos == null) {
            throw new ResourceNotFoundException("Nenhum tipo de residuo foi encontrado com o id: " + id_tipo_residuos);
        }
        return ResponseEntity.ok(tipoResiduos);
    }

    @PostMapping
    public ResponseEntity<?> createTipoResiduos(@Valid @RequestBody TipoResiduos tipoResiduos, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        TipoResiduos createdTipoResiduos = tipoResiduosService.createTipoResiduos(tipoResiduos);
        return ResponseEntity.ok(createdTipoResiduos);
    }

    @PutMapping("/{id_tipo_residuos}")
    public ResponseEntity<?> updateTipoResiduos(@PathVariable Integer id_tipo_residuos, @Valid @RequestBody TipoResiduos tipoResiduos, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        TipoResiduos updatedTipoResiduos = tipoResiduosService.updateTipoResiduos(id_tipo_residuos, tipoResiduos);
        if (updatedTipoResiduos == null) {
            throw new ResourceNotFoundException("Nenhum tipo de residuo foi encontrado com o id: " + id_tipo_residuos);
        }
        return ResponseEntity.ok(updatedTipoResiduos);
    }

    @DeleteMapping("/{id_tipo_residuos}")
    public ResponseEntity<String> deleteTipoResiduos(@PathVariable Integer id_log) {
        if (tipoResiduosService.existsById(id_log)) {
            tipoResiduosService.deleteTipoResiduos(id_log);
            return ResponseEntity.ok("Log deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Log com o ID " + id_log + " não foi encontrado.");
        }
    }
}

package br.com.fiap.project.service;

import br.com.fiap.project.model.*;
import br.com.fiap.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TipoResiduosService {

    @Autowired
    private TipoResiduosRepository tipoResiduosRepository;

    public List<TipoResiduos> getAllTipoResiduos() {
        return tipoResiduosRepository.findAll();
    }

    public TipoResiduos getTipoResiduosById(Integer id_tipo_residuos) {
        return tipoResiduosRepository.findById(id_tipo_residuos).orElse(null);
    }

    public TipoResiduos createTipoResiduos(TipoResiduos tipoResiduos) {
        return tipoResiduosRepository.save(tipoResiduos);
    }

    public TipoResiduos updateTipoResiduos(Integer id_tipo_residuos, TipoResiduos tipoResiduos) {
        if (tipoResiduosRepository.existsById(id_tipo_residuos)) {
            tipoResiduos.setId_tipo_residuos(id_tipo_residuos);
            return tipoResiduosRepository.save(tipoResiduos);
        }
        return null;
    }

    public void deleteTipoResiduos(Integer id_tipo_residuos) {tipoResiduosRepository.deleteById(id_tipo_residuos);}
    public boolean existsById(Integer id_tipo_residuos) {return tipoResiduosRepository.existsById(id_tipo_residuos);}
}

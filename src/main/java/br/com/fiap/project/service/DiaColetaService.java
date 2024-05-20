package br.com.fiap.project.service;

import br.com.fiap.project.model.*;
import br.com.fiap.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiaColetaService {

    @Autowired
    private DiaColetaRepository diaColetaRepository;

    public List<DiaColeta> getAllDiasColeta() {
        return diaColetaRepository.findAll();
    }

    public DiaColeta getDiaColetaById(Integer id_dia_coleta) {
        return diaColetaRepository.findById(id_dia_coleta).orElse(null);
    }

    public DiaColeta createDiaColeta(DiaColeta diaColeta) {
        return diaColetaRepository.save(diaColeta);
    }

    public DiaColeta updateDiaColeta(Integer id_dia_coleta, DiaColeta diaColeta) {
        if (diaColetaRepository.existsById(id_dia_coleta)) {
            diaColeta.setId_dia_coleta(id_dia_coleta);
            return diaColetaRepository.save(diaColeta);
        }
        return null;
    }

    public void deleteDiaColeta(Integer id_dia_coleta) {diaColetaRepository.deleteById(id_dia_coleta);}
    public boolean existsById(Integer id_dia_coleta) {return diaColetaRepository.existsById(id_dia_coleta);}
}

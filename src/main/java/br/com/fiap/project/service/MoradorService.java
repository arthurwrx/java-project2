package br.com.fiap.project.service;

import br.com.fiap.project.model.*;
import br.com.fiap.project.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public List<Morador> getAllMoradores() {
        return moradorRepository.findAll();
    }

    public Morador getMoradorById(Integer id_morador) {
        return moradorRepository.findById(id_morador).orElse(null);
    }

    public Morador createMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    public Morador updateMorador(Integer id_morador, Morador morador) {
        if (moradorRepository.existsById(id_morador)) {
            morador.setId_morador(id_morador);
            return moradorRepository.save(morador);
        }
        return null;
    }

    public void deleteMorador(Integer id_morador) {moradorRepository.deleteById(id_morador);}
    public boolean existsById(Integer id_morador) {return moradorRepository.existsById(id_morador);}
}

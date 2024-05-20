package br.com.fiap.project.service;

import br.com.fiap.project.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MoradorService {
    @Autowired
    private MoradorRepository moradorRepository;

    //Métodos de serviço
    //public List<Morador> getAllEntities() {
        //return MoradorRepository.findAll();
    //}

}

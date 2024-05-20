package br.com.fiap.project.repository;

import br.com.fiap.project.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Integer> {
    // Métodos de consulta personalizados, se necessário
}
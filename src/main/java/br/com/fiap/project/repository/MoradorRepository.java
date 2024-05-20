package br.com.fiap.project.repository;

import br.com.fiap.project.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
    // Métodos de consulta personalizados, se necessário
}
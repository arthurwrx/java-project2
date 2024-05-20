package br.com.fiap.project.repository;

import br.com.fiap.project.model.DiaColeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaColetaRepository extends JpaRepository<DiaColeta, Long> {
    // Métodos de consulta personalizados, se necessário
}

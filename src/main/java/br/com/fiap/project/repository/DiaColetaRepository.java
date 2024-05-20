package br.com.fiap.project.repository;

import br.com.fiap.project.model.DiaColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaColetaRepository extends JpaRepository<DiaColeta, Integer> {
    // Métodos de consulta personalizados, se necessário
}

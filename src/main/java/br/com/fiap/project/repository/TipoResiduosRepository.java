package br.com.fiap.project.repository;

import br.com.fiap.project.model.TipoResiduos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoResiduosRepository extends JpaRepository<TipoResiduos, Long> {
    // Métodos de consulta personalizados, se necessário
}

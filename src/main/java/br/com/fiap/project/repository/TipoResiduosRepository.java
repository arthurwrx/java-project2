package br.com.fiap.project.repository;

import br.com.fiap.project.model.TipoResiduos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoResiduosRepository extends JpaRepository<TipoResiduos, Integer> {
    // Métodos de consulta personalizados, se necessário
}

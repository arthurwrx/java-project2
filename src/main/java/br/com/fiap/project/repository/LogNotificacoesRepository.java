package br.com.fiap.project.repository;

import br.com.fiap.project.model.LogNotificacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogNotificacoesRepository extends JpaRepository<LogNotificacoes, Integer> {
    // Métodos de consulta personalizados, se necessário
}

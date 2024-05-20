package br.com.fiap.project.repository;

import br.com.fiap.project.model.LogNotificacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogNotificacoesRepository extends JpaRepository<LogNotificacoes, Long> {
    // Métodos de consulta personalizados, se necessário
}

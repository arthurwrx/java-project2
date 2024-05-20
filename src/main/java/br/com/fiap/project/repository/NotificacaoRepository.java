package br.com.fiap.project.repository;

import br.com.fiap.project.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    // Métodos de consulta personalizados, se necessário
}

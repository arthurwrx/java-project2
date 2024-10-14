package br.com.fiap.project.repository;

import br.com.fiap.project.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {
    // Métodos de consulta personalizados, se necessário
}

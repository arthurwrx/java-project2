package br.com.fiap.project.service;

import br.com.fiap.project.model.*;
import br.com.fiap.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public List<Notificacao> getAllNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao getNotificacaoById(Integer id_notificacao) {
        return notificacaoRepository.findById(id_notificacao).orElse(null);
    }

    public Notificacao createNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao updateNotificacao(Integer id_notificacao, Notificacao notificacao) {
        if (notificacaoRepository.existsById(id_notificacao)) {
            notificacao.setId_notificacao(id_notificacao);
            return notificacaoRepository.save(notificacao);
        }
        return null;
    }

    public void deleteNotificacao(Integer id_notificacao) {notificacaoRepository.deleteById(id_notificacao);}
    public boolean existsById(Integer id_notificacao) {return notificacaoRepository.existsById(id_notificacao);}
}


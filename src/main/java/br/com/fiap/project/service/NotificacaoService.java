package br.com.fiap.project.service;

import br.com.fiap.project.exception.NotificacaoNaoEncontradaException;
import br.com.fiap.project.http.NotificacaoClient;
import br.com.fiap.project.model.*;
import br.com.fiap.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private NotificacaoClient notificacaoClient;

    public void atualizarStatus(Long id_notificacao) throws NotificacaoNaoEncontradaException {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(id_notificacao);

        if (notificacaoOptional.isPresent()){
            notificacaoOptional.get().setStatus(String.valueOf(StatusEntrega.A_CAMINHO));
            notificacaoRepository.save(notificacaoOptional.get());
            notificacaoClient.atualizaNotificacao(notificacaoOptional.get().getId_notificacao());
        } else {
            throw new NotificacaoNaoEncontradaException(String.format("Pedido não encontrado"));
        }
    }

    public List<Notificacao> getAllNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao getNotificacaoById(Long id_notificacao) {
        return notificacaoRepository.findById(id_notificacao).orElse(null);
    }

    public Notificacao createNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao updateNotificacao(Long id_notificacao, Notificacao notificacao) {
        if (notificacaoRepository.existsById(id_notificacao)) {
            notificacao.setId_notificacao(id_notificacao);
            return notificacaoRepository.save(notificacao);
        }
        return null;
    }

    public void deleteNotificacao(Long id_notificacao) {notificacaoRepository.deleteById(id_notificacao);}
    public boolean existsById(Long id_notificacao) {return notificacaoRepository.existsById(id_notificacao);}
}


package br.com.fiap.project.service;

import br.com.fiap.project.model.*;
import br.com.fiap.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogNotificacoesService {

    @Autowired
    private LogNotificacoesRepository logNotificacoesRepository;

    public List<LogNotificacoes> getAllLogNotificacoes() {
        return logNotificacoesRepository.findAll();
    }

    public LogNotificacoes getLogNotificacoesById(Integer id_log_notificacoes) {
        return logNotificacoesRepository.findById(id_log_notificacoes).orElse(null);
    }

    public LogNotificacoes createLogNotificacoes(LogNotificacoes logNotificacoes) {
        return logNotificacoesRepository.save(logNotificacoes);
    }

    public LogNotificacoes updateLogNotificacoes(Integer id_log_notificacoes, LogNotificacoes logNotificacoes) {
        if (logNotificacoesRepository.existsById(id_log_notificacoes)) {
            logNotificacoes.setId_log(id_log_notificacoes);
            return logNotificacoesRepository.save(logNotificacoes);
        }
        return null;
    }

    public void deleteLogNotificacoes(Integer id_log_notificacoes) {logNotificacoesRepository.deleteById(id_log_notificacoes);}
    public boolean existsById(Integer id_log_notificacoes) {return logNotificacoesRepository.existsById(id_log_notificacoes);}
}

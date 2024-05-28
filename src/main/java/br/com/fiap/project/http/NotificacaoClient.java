package br.com.fiap.project.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("notificacao")
public interface NotificacaoClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/{id_notificacao}/tipostatus")
    void atualizaStatusNotificacao(@PathVariable("id_notificacao") Long id_notificacao);
}


package br.com.fiap.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotificacaoNaoEncontradaException extends Throwable {
    public NotificacaoNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}

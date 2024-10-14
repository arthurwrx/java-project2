package br.com.fiap.project.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_NOTIFICACAO")
public class Notificacao {
    @Id
    private Integer id_notificacao;
    private String email;
    private String mensagem;
    private String status;

    @Temporal(TemporalType.TIMESTAMP) // Você pode usar TIMESTAMP para incluir a hora
    private Date data_hora;

    @ManyToOne
    private Morador morador;

    @ManyToOne
    private DiaColeta diaColeta;

    @ManyToOne
    private TipoResiduos tipoResiduos;

    public Notificacao() {
    }

    public Integer getId_notificacao() {
        return id_notificacao;
    }

    public Notificacao setId_notificacao(Integer id_notificacao) {
        this.id_notificacao = id_notificacao;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Notificacao setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Notificacao setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Notificacao setStatus(String status) {
        this.status = status;
        return this;
    }
}

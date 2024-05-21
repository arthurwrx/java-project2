package br.com.fiap.project.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "TB_LOG_NOTIFICACOES")
public class LogNotificacoes {
    @Id
    private Integer id_log;
    private String tipo_operacao;
    private Timestamp data_hora;

    @OneToOne
    @JoinColumn(name = "id_notificacao")
    private Notificacao notificacao;

    public LogNotificacoes() {
    }

    public Integer getId_log() {
        return id_log;
    }

    public LogNotificacoes setId_log(Integer id_log) {
        this.id_log = id_log;
        return this;
    }

    public String getTipo_operacao() {
        return tipo_operacao;
    }

    public LogNotificacoes setTipo_operacao(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
        return this;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public LogNotificacoes setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
        return this;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public LogNotificacoes setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
        return this;
    }
}

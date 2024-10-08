package br.com.fiap.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TB_DIA_COLETA")
public class DiaColeta {
    @Id
    private Integer id_dia_coleta;
    private String data_hora;
    private String bairro;

    public DiaColeta() {
    }

    public Integer getId_dia_coleta() {
        return id_dia_coleta;
    }

    public void setId_dia_coleta(Integer id_dia_coleta) {
        this.id_dia_coleta = id_dia_coleta;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}

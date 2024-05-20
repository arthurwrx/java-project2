package br.com.fiap.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TIPO_RESIDUOS")
public class TipoResiduos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_residuos;
    private String descricao;

    public TipoResiduos() {
    }

    public Integer getId_tipo_residuos() {
        return id_tipo_residuos;
    }

    public TipoResiduos setId_tipo_residuos(Integer id_tipo_residuos) {
        this.id_tipo_residuos = id_tipo_residuos;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoResiduos setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}

package br.com.fiap.project.model;

import jakarta.persistence.*;

    @Entity
    @Table(name = "TB_MORADOR")
    public class Morador {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_morador;
        private String nome;
        private String endereco;
        private String email;



        public Morador() {}

        public Integer getId_morador() {
            return id_morador;
        }

        public Morador setId_morador(Integer id_morador) {
            this.id_morador = id_morador;
            return this;
        }

        public String getNome() {
            return nome;
        }

        public Morador setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public String getEndereco() {
            return endereco;
        }

        public Morador setEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Morador setEmail(String email) {
            this.email = email;
            return this;
        }
    }


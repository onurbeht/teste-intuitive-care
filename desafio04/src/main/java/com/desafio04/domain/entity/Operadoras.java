package com.desafio04.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tb_operadoras_plano_saude")
@Entity
public class Operadoras {

    @Id
    @Column(name = "registro_ans")
    private Integer registro_ans;

    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private String modalidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    private String fax;
    private String endereco_eletronico;
    private String representante;
    private String cargo_representante;
    private Integer regiao_de_comercializacao;

    @Column(name = "data_registro_ans")
    private LocalDate data;

    public Operadoras() {
    }

    private Operadoras(Integer registro_ans, String cnpj, String razao_social, String nome_fantasia, String modalidade,
            String logradouro, String numero, String complemento, String bairro, String cidade, String uf, String cep,
            String ddd, String telefone, String fax, String endereco_eletronico, String representante,
            String cargo_representante, Integer regiao_de_comercializacao, LocalDate data) {
        this.registro_ans = registro_ans;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.modalidade = modalidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.ddd = ddd;
        this.telefone = telefone;
        this.fax = fax;
        this.endereco_eletronico = endereco_eletronico;
        this.representante = representante;
        this.cargo_representante = cargo_representante;
        this.regiao_de_comercializacao = regiao_de_comercializacao;
        this.data = data;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Integer registro_ans;
        private String cnpj;
        private String razao_social;
        private String nome_fantasia;
        private String modalidade;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String uf;
        private String cep;
        private String ddd;
        private String telefone;
        private String fax;
        private String endereco_eletronico;
        private String representante;
        private String cargo_representante;
        private Integer regiao_de_comercializacao;
        private LocalDate data;

        public Builder registro_ans(Integer registro_ans) {
            this.registro_ans = registro_ans;
            return this;
        }

        public Builder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder razao_social(String razao_social) {
            this.razao_social = razao_social;
            return this;
        }

        public Builder nome_fantasia(String nome_fantasia) {
            this.nome_fantasia = nome_fantasia;
            return this;
        }

        public Builder modalidade(String modalidade) {
            this.modalidade = modalidade;
            return this;
        }

        public Builder logradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public Builder numero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder complemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder uf(String uf) {
            this.uf = uf;
            return this;
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder ddd(String ddd) {
            this.ddd = ddd;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public Builder endereco_eletronico(String endereco_eletronico) {
            this.endereco_eletronico = endereco_eletronico;
            return this;
        }

        public Builder representante(String representante) {
            this.representante = representante;
            return this;
        }

        public Builder cargo_representante(String cargo_representante) {
            this.cargo_representante = cargo_representante;
            return this;
        }

        public Builder regiao_de_comercializacao(Integer regiao_de_comercializacao) {
            this.regiao_de_comercializacao = regiao_de_comercializacao;
            return this;
        }

        public Builder data(LocalDate data) {
            this.data = data;
            return this;
        }

        public Operadoras build() {
            return new Operadoras(registro_ans, cnpj, razao_social, nome_fantasia, modalidade, logradouro, numero,
                    complemento, bairro, cidade, uf, cep, ddd, telefone, fax, endereco_eletronico, representante,
                    cargo_representante, regiao_de_comercializacao, data);
        }

    }

    public Integer getRegistro_ans() {
        return registro_ans;
    }

    public void setRegistro_ans(Integer registro_ans) {
        this.registro_ans = registro_ans;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEndereco_eletronico() {
        return endereco_eletronico;
    }

    public void setEndereco_eletronico(String endereco_eletronico) {
        this.endereco_eletronico = endereco_eletronico;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCargo_representante() {
        return cargo_representante;
    }

    public void setCargo_representante(String cargo_representante) {
        this.cargo_representante = cargo_representante;
    }

    public Integer getRegiao_de_comercializacao() {
        return regiao_de_comercializacao;
    }

    public void setRegiao_de_comercializacao(Integer regiao_de_comercializacao) {
        this.regiao_de_comercializacao = regiao_de_comercializacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}

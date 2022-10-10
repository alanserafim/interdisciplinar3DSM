package com.fatec.grupo3.model.entities;

import java.util.Objects;

public class Endereco {

    private Long id;
    private String cpf;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cpf, String cep, String logradouro, String complemento, String bairro, String localidade,
                    String uf) {
        this.cpf = cpf;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    // omitidos hashcode e equals
    // omitido toString

    @Override
    public int hashCode() {
        return Objects.hash(bairro, cep, complemento, cpf, id, localidade, logradouro, uf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
                && Objects.equals(complemento, other.complemento) && Objects.equals(cpf, other.cpf)
                && Objects.equals(id, other.id) && Objects.equals(localidade, other.localidade)
                && Objects.equals(logradouro, other.logradouro) && Objects.equals(uf, other.uf);
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", cpf=" + cpf + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento="
                + complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
    }

}

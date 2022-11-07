package com.fatec.grupo3.model.dto;

import java.util.List;

public class ExercicioDTO {

    private String titulo;
    private String enunciado;
    private List<String> afirmativas;
    private String resposta;

    public ExercicioDTO() {
    }

    public ExercicioDTO(String titulo, String enunciado, List<String> afirmativas, String resposta) {
        this.titulo = titulo;
        this.enunciado = enunciado;
        this.afirmativas = afirmativas;
        this.resposta = resposta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getAfirmativas() {
        return afirmativas;
    }

    public void setAfirmativas(List<String> afirmativas) {
        this.afirmativas = afirmativas;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}

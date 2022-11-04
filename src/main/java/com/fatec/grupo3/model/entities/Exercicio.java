package com.fatec.grupo3.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exercicio_id")
    private Long exercicioId;
    private String titulo;
    private String enunciado;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "exercicios_afirmativas", joinColumns = @JoinColumn(name = "exercicio_id"))
    @Column(name = "afirmativas_id")
    private List<String> afirmativas;
    private String resposta;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Exercicio() {
    }

    public Exercicio(Long exercicioId, String titulo, String enunciado, List<String> afirmativas, String resposta, Curso curso) {
        this.exercicioId = exercicioId;
        this.titulo = titulo;
        this.enunciado = enunciado;
        this.afirmativas = afirmativas;
        this.resposta = resposta;
        this.curso = curso;
    }

    public Long getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

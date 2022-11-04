package com.fatec.grupo3.model.entities;

import javax.persistence.*;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aula_id")
    private Long aulaId;
    private String titulo;
    private String video;
    private String conteudo;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Aula() {
    }

    public Aula(Long aulaId, String titulo, String video, String conteudo, Curso curso) {
        this.aulaId = aulaId;
        this.titulo = titulo;
        this.video = video;
        this.conteudo = conteudo;
        this.curso = curso;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

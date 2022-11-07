package com.fatec.grupo3.model.entities;

import javax.persistence.*;

@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historicoId;
    private String nomeCurso;
    private String duracaoCurso;
    private Double nota;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Matricula matricula;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    public Historico() {
    }

    public Historico(Long historicoId, String nomeCurso, String duracaoCurso, Double nota, Matricula matricula, Usuario usuario) {
        this.historicoId = historicoId;
        this.nomeCurso = nomeCurso;
        this.duracaoCurso = duracaoCurso;
        this.nota = nota;
        this.matricula = matricula;
        this.usuario = usuario;
    }

    public Long getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(Long historicoId) {
        this.historicoId = historicoId;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDuracaoCurso() {
        return duracaoCurso;
    }

    public void setDuracaoCurso(String duracaoCurso) {
        this.duracaoCurso = duracaoCurso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

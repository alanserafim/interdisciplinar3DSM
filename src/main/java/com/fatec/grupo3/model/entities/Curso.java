package com.fatec.grupo3.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.fatec.grupo3.model.entities.Usuario;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private String cargaHorario;
    private Usuario alunos;
    private String dataAtualizacao;
    private Double mediaAvaliacao;
    public Long getId() {
        return id;
    }

    public Curso() {
        super();
    }


    public Curso(Long id, String titulo, String descricao, String cargaHorario, Usuario alunos,
                 String dataAtualizacao, Double mediaAvaliacao) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHorario = cargaHorario;
        this.alunos = alunos;
        this.dataAtualizacao = dataAtualizacao;
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCargaHorario() {
        return cargaHorario;
    }
    public void setCargaHorario(String cargaHorario) {
        this.cargaHorario = cargaHorario;
    }
    public Usuario getAlunos() {
        return alunos;
    }
    public void setAlunos(Usuario alunos) {
        this.alunos = alunos;
    }
    public String getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public Double getMediaAvaliacao() {
        return mediaAvaliacao;
    }
    public void setMediaAvaliacao(Double mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }
}

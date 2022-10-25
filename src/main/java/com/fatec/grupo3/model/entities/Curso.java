package com.fatec.grupo3.model.entities;

import javax.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cursoId;
    private String titulo;
    private String descricao;
    private String cargaHorario;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;
    
    private String dataAtualizacao;
    private Double mediaAvaliacao;
    public Long getCursoId() {
        return cursoId;
    }

    public Curso() {
        super();
    }


    public Curso(Long cursoId, String titulo, String descricao, String cargaHorario, Usuario usuario,
                 String dataAtualizacao, Double mediaAvaliacao) {
        super();
        this.cursoId = cursoId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHorario = cargaHorario;
        this.usuario = usuario;
        this.dataAtualizacao = dataAtualizacao;
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

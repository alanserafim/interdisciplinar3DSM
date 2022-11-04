package com.fatec.grupo3.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cursoId;
    private String titulo;
    private String descricao;
    private String cargaHorario;
    private String categoria;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;
    private String dataAtualizacao;
    private Double mediaAvaliacao;

    @OneToOne(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private Matricula matricula;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Aula> aulas;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Exercicio> exercicios;

    public Long getCursoId() {
        return cursoId;
    }

    public Curso() {
        super();
    }

    public Curso(Long cursoId, String titulo, String descricao, String cargaHorario, String categoria, Usuario usuario, String dataAtualizacao, Double mediaAvaliacao, Matricula matricula, List<Aula> aulas, List<Exercicio> exercicios) {
        this.cursoId = cursoId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHorario = cargaHorario;
        this.categoria = categoria;
        this.usuario = usuario;
        this.dataAtualizacao = dataAtualizacao;
        this.mediaAvaliacao = mediaAvaliacao;
        this.matricula = matricula;
        this.aulas = aulas;
        this.exercicios = exercicios;
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

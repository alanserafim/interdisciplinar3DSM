package com.fatec.grupo3.model.entities;

import javax.persistence.*;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;
	
    private String status;
    private Double progresso;
    private Double avaliacaoCurso;

	@OneToOne
	@JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    
    public Matricula() {
    }

	public Matricula(Long id, Usuario usuario, String status, Double progresso, Double avaliacaoCurso, Curso curso) {
		this.id = id;
		this.usuario = usuario;
		this.status = status;
		this.progresso = progresso;
		this.avaliacaoCurso = avaliacaoCurso;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public Double getProgresso() {
		return progresso;
	}


	public void setProgresso(Double progresso) {
		this.progresso = progresso;
	}


	public Double getAvaliacaoCurso() {
		return avaliacaoCurso;
	}


	public void setAvaliacaoCurso(Double avaliacaoCurso) {
		this.avaliacaoCurso = avaliacaoCurso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}

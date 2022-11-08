package com.fatec.grupo3.model.entities;

import javax.persistence.*;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matriculaId;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;
	
    private String status;
    private Double nota;
    private Double avaliacaoCurso;

	@OneToOne
	@JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Matricula() {
    }

	public Matricula(Long matriculaId, Usuario usuario, String status, Double nota, Double avaliacaoCurso, Curso curso) {
		this.matriculaId = matriculaId;
		this.usuario = usuario;
		this.status = status;
		this.nota = nota;
		this.avaliacaoCurso = avaliacaoCurso;
		this.curso = curso;
	}

	public Long getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Long matriculaId) {
		this.matriculaId = matriculaId;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public Double getNota() {
		return nota;
	}


	public void setNota(Double nota) {
		this.nota = nota;
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

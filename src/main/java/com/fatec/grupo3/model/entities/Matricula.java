package com.fatec.grupo3.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Usuario usuario;
    private String status;
    private Double progresso;
    private Double avaliacaoCurso;
    //private Curso curso
    
    
    public Matricula() {
    	super();
    }

    public Matricula(Long id, Usuario usuario, String status, Double progresso, Double avaliacaoCurso) {
        this.id = id;
    	this.usuario = usuario;
        this.status = status;
        this.progresso = progresso;
        this.avaliacaoCurso = avaliacaoCurso;
    }


	public long getId() {
		return id;
	}


	public void setId(long matriculaId) {
		this.id = matriculaId;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

   
}

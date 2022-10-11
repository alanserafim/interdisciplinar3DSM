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
    private long matriculaId;
    @OneToOne
    private Usuario usuario;
    //private Curso curso
    @Column
    private String status;
    @Column
    private Double progresso;
    @Column
    private Double avaliacaoCurso;

    Matricula(Usuario usuario){
        this.usuario = usuario;
        status = "Em Andamento";
        progresso = 0.0;
        avaliacaoCurso = 0.0;
    }


    public Matricula(Usuario usuario, String status, Double progresso, Double avaliacaoCurso) {
        this.usuario = usuario;
        this.status = status;
        this.progresso = progresso;
       this.avaliacaoCurso = avaliacaoCurso;
    }


	public long getMatriculaId() {
		return matriculaId;
	}


	public void setMatriculaId(long matriculaId) {
		this.matriculaId = matriculaId;
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

package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class MatriculaDTO {
	
	@ApiModelProperty(value = "Dono da matricula")
    private ProfileDTO usuario;
	
	@ApiModelProperty(value = "Status da Matricula")
    private String status;
	
	@ApiModelProperty(value = "Progresso da matricula")
    private Double progresso;
	
	@ApiModelProperty(value = "Nota que o usuario deu para o curso")
    private Double avaliacaoCurso;
	
	@ApiModelProperty(value = "Curso que o aluno está matriculado")
    private CursoDTO curso;

    public MatriculaDTO(ProfileDTO usuario, String status, Double progresso, Double avaliacaoCurso, CursoDTO curso) {
        this.usuario = usuario;
        this.status = status;
        this.progresso = progresso;
        this.avaliacaoCurso = avaliacaoCurso;
        this.curso = curso;
    }

    public ProfileDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(ProfileDTO usuario) {
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

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }
}

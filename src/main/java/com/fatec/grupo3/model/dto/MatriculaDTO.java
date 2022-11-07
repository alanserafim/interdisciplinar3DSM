package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class MatriculaDTO {
	
	@ApiModelProperty(value = "Status da Matricula")
    private String status;
	
	@ApiModelProperty(value = "Nota do aluno matriculado")
    private Double nota;
	
	@ApiModelProperty(value = "Nota que o usuario deu para o curso")
    private Double avaliacaoCurso;

    public MatriculaDTO(String status, Double nota, Double avaliacaoCurso) {
        this.status = status;
        this.nota = nota;
        this.avaliacaoCurso = avaliacaoCurso;
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

}

package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class MatriculaDTO {
	
	@ApiModelProperty(value = "Status da Matricula")
    private String status;
	
	@ApiModelProperty(value = "Progresso da matricula")
    private Double progresso;
	
	@ApiModelProperty(value = "Nota que o usuario deu para o curso")
    private Double avaliacaoCurso;

    public MatriculaDTO(String status, Double progresso, Double avaliacaoCurso) {
        this.status = status;
        this.progresso = progresso;
        this.avaliacaoCurso = avaliacaoCurso;
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

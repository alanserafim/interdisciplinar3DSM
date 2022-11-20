package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class MatriculasDTO {

    private Long matriculaId;

    @ApiModelProperty(value = "Status da Matricula")
    private String status;

    @ApiModelProperty(value = "Nota do aluno matriculado")
    private Double nota;

    @ApiModelProperty(value = "Nota que o usuario deu para o curso")
    private Double avaliacaoCurso;

    private ListaCursoDTO curso;

    public MatriculasDTO(Long matriculaId, String status, Double nota, Double avaliacaoCurso, ListaCursoDTO curso) {
        this.matriculaId = matriculaId;
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

    public ListaCursoDTO getCurso() {
        return curso;
    }

    public void setCurso(ListaCursoDTO curso) {
        this.curso = curso;
    }
}

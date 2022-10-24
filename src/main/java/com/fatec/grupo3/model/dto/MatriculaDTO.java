package com.fatec.grupo3.model.dto;

public class MatriculaDTO {

    private ProfileDTO usuario;
    private String status;
    private Double progresso;
    private Double avaliacaoCurso;
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

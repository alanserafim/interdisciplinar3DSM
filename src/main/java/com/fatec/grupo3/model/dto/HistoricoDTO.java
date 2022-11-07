package com.fatec.grupo3.model.dto;

public class HistoricoDTO {

    private Long historicoId;
    private String nomeCurso;
    private String duracaoCurso;
    private Double nota;

    public HistoricoDTO() {
    }

    public HistoricoDTO(Long historicoId, String nomeCurso, String duracaoCurso, Double nota) {
        this.historicoId = historicoId;
        this.nomeCurso = nomeCurso;
        this.duracaoCurso = duracaoCurso;
        this.nota = nota;
    }

    public Long getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(Long historicoId) {
        this.historicoId = historicoId;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDuracaoCurso() {
        return duracaoCurso;
    }

    public void setDuracaoCurso(String duracaoCurso) {
        this.duracaoCurso = duracaoCurso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}

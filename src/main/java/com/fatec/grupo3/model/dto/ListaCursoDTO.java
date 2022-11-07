package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ListaCursoDTO {
    @NotNull
    @ApiModelProperty(value = "id")
    private Long cursoId;

    @ApiModelProperty(value = "Titulo do curso")
    private String titulo;
    @ApiModelProperty(value = "Descrição do curso")
    private String descricao;
    @ApiModelProperty(value = "Carga Horaria do curso")
    private String cargaHorario;
    @ApiModelProperty(value = "Data de Atualização do curso cadastrado")
    private String dataAtualizacao;
    @ApiModelProperty(value = "Media de Avaliação do curso cadastrado (feedback do alunos)")
    private Double mediaAvaliacao;

    @ApiModelProperty(value = "Aulas que serão ministradas")
    private List<AulaDTO> aulas;

    @ApiModelProperty(value = "Exercicios que serão ministrados")
    private List<ExercicioDTO> exercicios;

    public ListaCursoDTO(Long cursoId, String titulo, String descricao, String cargaHorario, String dataAtualizacao, Double mediaAvaliacao, List<AulaDTO> aulas, List<ExercicioDTO> exercicios) {
        this.cursoId = cursoId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHorario = cargaHorario;
        this.dataAtualizacao = dataAtualizacao;
        this.mediaAvaliacao = mediaAvaliacao;
        this.aulas = aulas;
        this.exercicios = exercicios;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(String cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public void setMediaAvaliacao(Double mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public List<AulaDTO> getAulas() {
        return aulas;
    }

    public void setAulas(List<AulaDTO> aulas) {
        this.aulas = aulas;
    }

    public List<ExercicioDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExercicioDTO> exercicios) {
        this.exercicios = exercicios;
    }
}

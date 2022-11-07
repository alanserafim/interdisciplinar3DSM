package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CursoDTO {

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
    @ApiModelProperty(value = "Categoria onde o curso se encontra")
    private String categoria;

    /*@ApiModelProperty(value = "Aulas que serão ministradas")
    private List<AulaDTO> aulas;

    @ApiModelProperty(value = "Exercicios que serão ministrados")
    private List<ExercicioDTO> exercicios;*/

    public CursoDTO(String titulo, String descricao, String cargaHorario, String dataAtualizacao, Double mediaAvaliacao, List<AulaDTO> aulas, List<ExercicioDTO> exercicios, String categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHorario = cargaHorario;
        this.dataAtualizacao = dataAtualizacao;
        this.mediaAvaliacao = mediaAvaliacao;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

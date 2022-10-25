package com.fatec.grupo3.model.dto;

import com.fatec.grupo3.model.entities.Usuario;

import io.swagger.annotations.ApiModelProperty;

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

    public CursoDTO(String titulo, String descricao, String cargaHorario, String dataAtualizacao, Double mediaAvaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHorario = cargaHorario;
        this.dataAtualizacao = dataAtualizacao;
        this.mediaAvaliacao = mediaAvaliacao;
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
}

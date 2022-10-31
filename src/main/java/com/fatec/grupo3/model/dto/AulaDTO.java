package com.fatec.grupo3.model.dto;

public class AulaDTO {
    private String titulo;
    private String video;
    private String conteudo;

    public AulaDTO() {
    }

    public AulaDTO(String titulo, String video, String conteudo) {
        this.titulo = titulo;
        this.video = video;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}

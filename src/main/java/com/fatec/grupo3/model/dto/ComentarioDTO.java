package com.fatec.grupo3.model.dto;

public class ComentarioDTO {

    private String comentario;

    public ComentarioDTO() {
    }

    public ComentarioDTO(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

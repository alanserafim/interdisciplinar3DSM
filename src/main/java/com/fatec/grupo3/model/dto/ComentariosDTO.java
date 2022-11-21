package com.fatec.grupo3.model.dto;

public class ComentariosDTO {
    private Long comentarioId;
    private String comentario;
    private String username;
    private String name;
    private String lastname;

    public ComentariosDTO() {
    }

    public ComentariosDTO(Long comentarioId, String comentario, String username, String name, String lastname) {
        this.comentarioId = comentarioId;
        this.comentario = comentario;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

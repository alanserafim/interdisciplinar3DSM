package com.fatec.grupo3.model.dto;

public class ComentariosDTO {
    private Long id;
    private String comentario;
    private String username;
    private String name;
    private String lastname;

    public ComentariosDTO() {
    }

    public ComentariosDTO(Long id, String comentario, String username, String name, String lastname) {
        this.id = id;
        this.comentario = comentario;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

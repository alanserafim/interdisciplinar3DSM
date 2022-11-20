package com.fatec.grupo3.model.entities;

import javax.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comentario_id")
    private Long comentarioId;

    @Column(length=800)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aula aula;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(Long comentarioId, String comentario, Aula aula, Usuario usuario) {
        this.comentarioId = comentarioId;
        this.comentario = comentario;
        this.aula = aula;
        this.usuario = usuario;
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

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

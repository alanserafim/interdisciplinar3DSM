package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.entities.Curso;

import java.util.List;
import java.util.Optional;

public interface CursosService {

    List<Curso> consultaTodos();
    Optional<Curso> consultaPorTitulo(String titulo);
    Optional<Curso> save(Curso curso);
    void delete (Long id);
    Optional<Curso> atualiza (Curso curso);
}

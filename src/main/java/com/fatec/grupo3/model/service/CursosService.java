package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.entities.Curso;

import java.util.List;
import java.util.Optional;

public interface CursosService {

    List<CursoDTO> consultaTodos();
    Optional<CursoDTO> consultaPorTitulo(String titulo);
    Optional<CursoDTO> save(CursoDTO cursoDTO, String token);
    void delete (Long id, String token);
    Optional<CursoDTO> atualiza (CursoDTO cursoDTO, String token);

    Optional<CursoDTO> consultarPorId(Long id);
}

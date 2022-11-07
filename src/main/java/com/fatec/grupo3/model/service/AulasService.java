package com.fatec.grupo3.model.service;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.exception.NotFoundException;
import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.ListaAulaDTO;
import com.fatec.grupo3.model.dto.ListaCursoDTO;
import com.fatec.grupo3.model.entities.Aula;

import java.util.List;
import java.util.Optional;

public interface AulasService {
    List<ListaAulaDTO> consultaTodos(Long cursoId);
    Optional<AulaDTO> consultaPorTitulo(String titulo);
    Optional<AulaDTO> save(Long cursoId, AulaDTO aulaDTO);
    void delete (Long id);
    Optional<AulaDTO> atualiza(Long cursoId, Long aulaId, AulaDTO aulaDTO) throws NotFoundException;
    Optional<AulaDTO> consultarPorId(Long id) throws AreaProibidaException;
}

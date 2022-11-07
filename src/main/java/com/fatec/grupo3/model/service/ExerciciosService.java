package com.fatec.grupo3.model.service;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.exception.NotFoundException;
import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.dto.ListaExercicioDTO;

import java.util.List;
import java.util.Optional;

public interface ExerciciosService {

    List<ListaExercicioDTO> consultaTodos(Long cursoId);
    //Optional<ExercicioDTO> consultaPorTitulo(String titulo);
    Optional<ExercicioDTO> save(Long cursoId, ExercicioDTO exercicioDTO);
    void delete (Long id);
    Optional<ExercicioDTO> atualiza(Long cursoId, Long exercicioId, ExercicioDTO exercicioDTO) throws NotFoundException;
    Optional<ExercicioDTO> consultarPorId(Long id) throws AreaProibidaException;
}

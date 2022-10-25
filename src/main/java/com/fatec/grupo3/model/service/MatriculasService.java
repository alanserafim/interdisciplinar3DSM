package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface MatriculasService {

    List<MatriculaDTO> consultaTodos();
    //Optional<Matricula> consultaPorUsuario(String cpf);
    Optional<MatriculaDTO> consultaPorId(Long id);
    Optional<MatriculaDTO> save(MatriculaDTO matricula, Long idCurso, String token);
    void delete (Long id);
    Optional<MatriculaDTO> atualiza(Long id, MatriculaDTO matricula, String token);
}

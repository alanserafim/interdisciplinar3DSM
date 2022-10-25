package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface MatriculasService {

    List<Matricula> consultaTodos();
    
    //Optional<Matricula> consultaPorUsuario(String cpf);
    Matricula cadastrarMatricula(MatriculaDTO matriculaDTO);
    Optional<Matricula> consultaPorId(Long id);
    void delete (Long id);
    Optional<Matricula> atualiza(Matricula matricula);
}

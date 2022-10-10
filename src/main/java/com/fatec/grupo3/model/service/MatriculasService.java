package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface MatriculasService {

    List<Matricula> consultaTodos();
    Optional<Matricula> consultaPorUsuario(String cpf);
    Optional<Matricula> save(Matricula matricula);
    void delete (Long id);
    Optional<Matricula> atualiza(Matricula matricula);
}

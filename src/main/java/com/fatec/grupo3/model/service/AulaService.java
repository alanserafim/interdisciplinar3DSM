package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.entities.Aula;

import java.util.List;
import java.util.Optional;

public interface AulaService {
	List<Aula> consultaTodos();
	Optional<Aula> consultaPorTitulo(String titulo);
    Optional<Aula> save(Aula aula);
    void delete (Long id);
    Optional<Aula> atualiza (Aula aula);

    Optional<Aula> consultarPorId(Long id);
}

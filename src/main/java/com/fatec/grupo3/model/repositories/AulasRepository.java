package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AulasRepository extends JpaRepository<Aula, Long> {

    Optional<Aula> findByTitulo(String titulo);

    List<Aula> findByCurso(Curso curso);
}

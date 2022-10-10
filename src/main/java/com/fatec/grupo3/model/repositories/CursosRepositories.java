package com.fatec.grupo3.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.grupo3.model.entities.Curso;

@Repository
public interface CursosRepositories extends JpaRepository<Curso, Long> {
    Optional<Curso> findCursoByTitulo(String titulo);
}

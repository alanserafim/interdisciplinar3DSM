package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>  {

    List<Exercicio> findByCurso(Curso curso);
}

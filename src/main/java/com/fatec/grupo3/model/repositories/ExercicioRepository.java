package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.entities.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long>  {
}

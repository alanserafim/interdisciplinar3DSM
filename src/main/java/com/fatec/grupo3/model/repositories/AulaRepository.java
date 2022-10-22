package com.fatec.grupo3.model.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.grupo3.model.entities.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>{
	Optional<Aula> findAulaByTitulo(String titulo);
}

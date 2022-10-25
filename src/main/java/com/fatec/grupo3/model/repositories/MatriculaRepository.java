package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.entities.Cliente;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
   List<Matricula> findByCpf(@Param("cpf") String cpf);
	
	/* Optional<Matricula> findByUsuario(Usuario usuario);
    Optional<Matricula> findByUsuario(Optional<Usuario> usuario);*/
}

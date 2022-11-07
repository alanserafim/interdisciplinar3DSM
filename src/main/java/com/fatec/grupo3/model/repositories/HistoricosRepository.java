package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.entities.Historico;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricosRepository extends JpaRepository<Historico, Long> {

    List<Historico> findAllByUsuario(Usuario usuario);

    Optional<Historico> findByMatricula(Matricula matricula);
}

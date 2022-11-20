package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findAllByUsuario(Usuario usuario);
    void deleteByUsuarioAndMatriculaId(Usuario usuario, Long id);
    @Query("SELECT u FROM Matricula m join m.usuario u WHERE m.curso.cursoId = :cursoId")
    List<Usuario> findUsuariosByCursoId(@Param("cursoId") Long cursoId);
}

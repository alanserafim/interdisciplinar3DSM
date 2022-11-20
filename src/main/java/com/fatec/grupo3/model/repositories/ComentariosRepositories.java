package com.fatec.grupo3.model.repositories;

import com.fatec.grupo3.model.dto.ComentariosDTO;
import com.fatec.grupo3.model.entities.Comentario;
import com.fatec.grupo3.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentariosRepositories extends JpaRepository<Comentario, Long> {
    @Query("SELECT NEW com.fatec.grupo3.model.dto.ComentariosDTO(c.id, c.comentario, u.username, u.name, u.lastname) FROM Comentario c INNER JOIN c.usuario u WHERE c.aula.aulaId = (:aulaId)")
    List<ComentariosDTO> findAllByAula(@Param("aulaId") Long aulaId);
}

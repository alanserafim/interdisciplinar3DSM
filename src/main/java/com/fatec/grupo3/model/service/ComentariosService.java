package com.fatec.grupo3.model.service;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.ComentarioDTO;
import com.fatec.grupo3.model.dto.ComentariosDTO;

import java.util.List;
import java.util.Optional;

public interface ComentariosService {

    List<ComentariosDTO> consultaTodos(Long aulaId);
    Optional<ComentarioDTO> save(ComentarioDTO comentarioDTO, Long aulaId, String token);
    void delete (Long id);
    Optional<ComentarioDTO> atualiza (Long id, Long aulaId, ComentarioDTO comentarioDTO, String token);
}

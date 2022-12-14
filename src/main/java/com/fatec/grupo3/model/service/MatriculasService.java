package com.fatec.grupo3.model.service;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.HistoricoDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.dto.MatriculasDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface MatriculasService {

    List<MatriculasDTO> consultaTodos(String token);
    Optional<MatriculasDTO> consultaPorId(Long id, String token) throws AreaProibidaException;
    Optional<MatriculaDTO> save(MatriculaDTO matricula, Long idCurso, String token);
    void delete (Long id, String token);
    Optional<MatriculaDTO> atualiza(Long id, Long idCurso, Double nota, String token) throws AreaProibidaException;
    List<HistoricoDTO> consultarHistorico(String token);
    List<UsuarioDTO> consultarUsuariosMatriculados(Long cursoId);
    //List<MatriculasDTO> consultarCursoPorMatriculaId(Long id);
}

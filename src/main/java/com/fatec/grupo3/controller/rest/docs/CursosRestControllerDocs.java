package com.fatec.grupo3.controller.rest.docs;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.ErrorDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Curso;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@Api(value = "/api/v1/cursos",  description = "Operações relacionadas aos Cursos")
public interface CursosRestControllerDocs {

    @ApiOperation(value = "Cadastrar Curso", nickname = "createCurso", notes = "", response = CursoDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Cursos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Curso Cadastrado!", response = CursoDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<CursoDTO>> createCurso(@Valid @RequestBody CursoDTO curso, HttpServletRequest request) throws Exception;
    
    @ApiOperation(value = "Cadastrar Curso", nickname = "updateMatricula", notes = "", response = MatriculaDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Cursos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Curso Atualizada!", response = CursoDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<CursoDTO>> updateCurso(@PathVariable Long id, @Valid @RequestBody CursoDTO matricula, HttpServletRequest request) throws Exception;
 
 	
 @ApiOperation(value = "Listar Curso do Aluno", nickname = "listMatricula", notes = "", response = CursoDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Cursos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cursos Listados com sucesso", response = CursoDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping
    public ResponseEntity<List<CursoDTO>> listCurso(HttpServletRequest request);

}

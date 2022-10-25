package com.fatec.grupo3.controller.rest.docs;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.ErrorDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Curso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "/api/v1/matriculas",  description = "Operações relacionadas as Matriculas")
public interface MatriculasRestControllerDocs {
	
	 @ApiOperation(value = "Cadastrar Matricula", nickname = "createMatricula", notes = "", response = MatriculaDTO.class, responseContainer = "object", authorizations = {
	            @Authorization(value = "Authorization") }, tags = { "Matriculas", })
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Matricula Cadastrada!", response = MatriculaDTO.class, responseContainer = "object"),
	            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
	            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
	            @ApiResponse(code = 404, message = "Usuário não encontrada") })
	    @PostMapping
	    public ResponseEntity<Optional<MatriculaDTO>> createMatricula(@Valid @RequestBody MatriculaDTO matricula, @PathVariable Long idCurso, HttpServletRequest request) throws Exception;
	 
	 @ApiOperation(value = "Cadastrar Matricula", nickname = "updateMatricula", notes = "", response = MatriculaDTO.class, responseContainer = "object", authorizations = {
	            @Authorization(value = "Authorization") }, tags = { "Matriculas", })
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Matricula Atualizada!", response = MatriculaDTO.class, responseContainer = "object"),
	            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
	            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
	            @ApiResponse(code = 404, message = "Usuário não encontrada") })
	    @PostMapping
	    public ResponseEntity<Optional<MatriculaDTO>> updateMatricula(@PathVariable Long id, @Valid @RequestBody MatriculaDTO matricula, HttpServletRequest request) throws Exception;
	 
	 	
	 @ApiOperation(value = "Listar Matriculas do Aluno", nickname = "listMatricula", notes = "", response = MatriculaDTO.class, responseContainer = "object", authorizations = {
	            @Authorization(value = "Authorization") }, tags = { "Matriculas", })
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Emprestimos Listados com sucesso", response = MatriculaDTO.class, responseContainer = "object"),
	            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
	            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
	            @ApiResponse(code = 404, message = "Usuário não encontrado") })
	    @GetMapping
	    public ResponseEntity<List<MatriculaDTO>> listMatricula(HttpServletRequest request);
}

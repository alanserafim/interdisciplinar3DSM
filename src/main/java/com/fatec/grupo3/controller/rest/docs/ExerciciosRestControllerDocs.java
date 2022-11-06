package com.fatec.grupo3.controller.rest.docs;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.dto.ErrorDTO;
import com.fatec.grupo3.model.dto.ListaExercicioDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "/api/v1/exercicios",  description = "Operações relacionadas aos Exercicios")
public interface ExerciciosRestControllerDocs {
    
    @ApiOperation(value = "Cadastrar Exercicio", nickname = "createExercicio", notes = "", response = ExercicioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Exercicio", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exercicio Cadastrada!", response = ExercicioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<ExercicioDTO>> createExercicio(@PathVariable Long cursoId, @Valid @RequestBody ExercicioDTO exercicioDTO) throws Exception;

    @ApiOperation(value = "Atualizar Exercicio", nickname = "updateExercicio", notes = "", response = ExercicioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Exercicio", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exercicio Atualizada!", response = ExercicioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<ExercicioDTO>> updateExercicio(@PathVariable Long cursoId, @PathVariable Long id, @Valid @RequestBody ExercicioDTO exercicioDTO) throws Exception;


    @ApiOperation(value = "Lista Exercicios", nickname = "listExercicio", notes = "", response = ExercicioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Exercicio", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exercicio Listada!", response = ExercicioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<List<ListaExercicioDTO>> listExercicio(@PathVariable Long cursoId);

    @ApiOperation(value = "Deletar uma Exercicio", nickname = "deleteExercicio", notes = "", response = ExercicioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Exercicio", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exercicio deletada com sucesso", response = ExercicioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @DeleteMapping
    public void deleteExercicio(@PathVariable("id") Long id);

    @ApiOperation(value = "Consultar uma Exercicio", nickname = "consultaExercicio", notes = "", response = ExercicioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Exercicio", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exercicios consultada com sucesso", response = ExercicioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping
    public ResponseEntity<Optional<ExercicioDTO>> consultaExercicio(@PathVariable("id") Long id) throws AreaProibidaException;
}

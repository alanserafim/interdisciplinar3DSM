package com.fatec.grupo3.controller.rest.docs;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "/api/v1/aulas",  description = "Operações relacionadas às Aulas")
public interface AulasRestControllerDocs {

    @ApiOperation(value = "Cadastrar Aula", nickname = "createAula", notes = "", response = AulaDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Aula", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aula Cadastrada!", response = AulaDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<AulaDTO>> createAula(@PathVariable Long cursoId, @Valid @RequestBody AulaDTO aulaDTO) throws Exception;

    @ApiOperation(value = "Atualizar Aula", nickname = "updateAula", notes = "", response = AulaDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Aula", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aula Atualizada!", response = AulaDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<AulaDTO>> updateAula(@PathVariable Long cursoId, @PathVariable Long id, @Valid @RequestBody AulaDTO aulaDTO) throws Exception;


    @ApiOperation(value = "Lista Aulas", nickname = "listAula", notes = "", response = AulaDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Aula", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aula Listada!", response = AulaDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<List<ListaAulaDTO>> listAula(@PathVariable Long cursoId);

    @ApiOperation(value = "Deletar uma Aula", nickname = "deleteAula", notes = "", response = AulaDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Aula", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aula deletada com sucesso", response = AulaDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @DeleteMapping
    public void deleteAula(@PathVariable("id") Long id);

    @ApiOperation(value = "Consultar uma Aula", nickname = "consultaAula", notes = "", response = AulaDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Aula", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aulas consultada com sucesso", response = AulaDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping
    public ResponseEntity<Optional<AulaDTO>> consultaAula(@PathVariable("id") Long id) throws AreaProibidaException;

}

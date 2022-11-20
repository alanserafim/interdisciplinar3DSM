package com.fatec.grupo3.controller.rest.docs;

import com.fatec.grupo3.model.dto.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "/api/v1/comentarios",  description = "Operações relacionadas aos Comentarios")
public interface ComentariosRestControllerDocs {

    @ApiOperation(value = "Comentar", nickname = "createComentario", notes = "", response = ComentarioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Comentarios", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comentario Cadastrado!", response = ComentarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<ComentarioDTO>> comentar(@Valid @RequestBody ComentarioDTO comentario, @PathVariable("aulaId") Long aulaId, HttpServletRequest request) throws Exception;

    @ApiOperation(value = "Listar Comentarios cadastrado", nickname = "listComentarios", notes = "", response = ComentariosDTO.class, responseContainer = "object", tags = { "Comentarios", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comentarios Listados com sucesso", response = ComentariosDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping
    public ResponseEntity<List<ComentariosDTO>> listComentarios(@PathVariable("aulaId") Long aulaId);

    @ApiOperation(value = "Deletar um comentario", nickname = "deleteComentario", notes = "", response = ComentarioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Comentarios", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comentarios deletado com sucesso", response = ComentarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @DeleteMapping
    public void deleteComentario(@PathVariable("id") Long id);
}

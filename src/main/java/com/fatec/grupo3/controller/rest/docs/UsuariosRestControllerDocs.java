package com.fatec.grupo3.controller.rest.docs;

import com.fatec.grupo3.model.dto.*;
import com.fatec.grupo3.model.entities.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(value = "/api/v1/usuarios",  description = "Operações relacionadas aos Usuarios")
public interface UsuariosRestControllerDocs {

    @ApiOperation(value = "Cadastrar um usuario", nickname = "signUp", notes = "", response = Usuario.class, responseContainer = "object", tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Cadastrado no sistema", response = Usuario.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object")})
    @PostMapping("/signUp")
    public ResponseEntity<UsuarioDTO> signUp(@RequestBody @Valid UsuarioDTO usuarioDto);

    @ApiOperation(value = "Logar no sistema", nickname = "signIn", notes = "", response = TokenDTO.class, responseContainer = "object", tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Logado com sucesso!", response = TokenDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid LoginDTO loginDTO);

    @ApiOperation(value = "Dados do usuario logado", nickname = "me", notes = "", response = Usuario.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do usuario encontrado com sucesso!", response = Usuario.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrados") })
    @GetMapping("/me")
    public ResponseEntity<UsuarioDTO> me(HttpServletRequest request);
    
    @ApiOperation(value = "Atualizar Usuario", nickname = "updateUsuario", notes = "", response = UsuarioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Atualizado!", response = UsuarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<UsuarioDTO>> updateUsuario(HttpServletRequest request, @RequestBody @Valid UsuarioDTO usuarioDto) throws Exception;


    @ApiOperation(value = "Atualizar Outro Usuario", nickname = "updateOutroUsuario", notes = "", response = UsuarioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Atualizado!", response = UsuarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<Optional<UsuarioDTO>> updateOutroUsuario(@PathVariable("id") Long id, HttpServletRequest request, @RequestBody @Valid UsuarioDTO usuarioDto) throws Exception;

    @ApiOperation(value = "Consultar Usuarios", nickname = "consultarUsuarios", notes = "", response = UsuarioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuarios Consultados!", response = UsuarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<List<ListaDTO>> consultarUsuarios(HttpServletRequest request) throws Exception;

    @ApiOperation(value = "Deletar Usuario", nickname = "deleteUsuario", notes = "", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Deletado!", response = HttpStatusCodeException.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @DeleteMapping
    public void deletarUsuario(@PathVariable("id")  Long id, HttpServletRequest request) throws Exception;

    @ApiOperation(value = "Consultar Usuario", nickname = "consultarUsuario", notes = "", response = UsuarioDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Usuario", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Consultados!", response = UsuarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<UsuarioDTO> consultarUsuario(@PathVariable("id") Long id, HttpServletRequest request) throws Exception;
}

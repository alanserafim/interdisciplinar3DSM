package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Token;
import com.fatec.grupo3.model.entities.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(value = "/api/v1/users",  description = "Operações relacionadas aos Usuarios")
public interface UsuariosRestControllerDocs {

    @ApiOperation(value = "Cadastrar um usuario", nickname = "signUp", notes = "", response = Usuario.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Cadastrado no sistema", response = Usuario.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = Error.class, responseContainer = "object")})
    @PostMapping("/signUp")
    public ResponseEntity<Usuario> signUp(@RequestBody @Valid Usuario usuario);

    @ApiOperation(value = "Logar no sistema", nickname = "signIn", notes = "", response = Token.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Logado com sucesso!", response = Token.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = Error.class, responseContainer = "object"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping("/signIn")
    public ResponseEntity<Token> signIn(@RequestBody @Valid Login login);

    @ApiOperation(value = "Dados do usuario logado", nickname = "me", notes = "", response = Usuario.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do usuario encontrado com sucesso!", response = Usuario.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = Error.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrados") })
    @GetMapping("/me")
    public ResponseEntity<Usuario> me(HttpServletRequest request);
}

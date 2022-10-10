package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Token;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/usuarios")
public class UsuariosRestController {

    @Autowired
    private UsuariosService service;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> signUp(@RequestBody @Valid Usuario usuario) {
        Usuario responseBody = service.cadastrar(usuario);

        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<Token> signIn(@RequestBody @Valid Login login) {
        return ResponseEntity.ok(service.logar(login));
    }

    @GetMapping("/perfil")
    public ResponseEntity<Usuario> me(HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);
        return ResponseEntity.ok(service.perfil(token));
    }
}

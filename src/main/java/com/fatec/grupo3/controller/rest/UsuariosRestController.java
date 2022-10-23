package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.UsuariosRestControllerDocs;
import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Token;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.security.Profiles;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "https://alanserafim.github.io/fatecflix-angular/")
@RequestMapping("/api/v1/usuarios")
public class UsuariosRestController implements UsuariosRestControllerDocs {

    @Autowired
    private UsuariosService service;

    @Override
    @PostMapping("/signUp")
    public ResponseEntity<Usuario> signUp(Usuario usuario) {
        Usuario responseBody = service.cadastrar(usuario);

        return ResponseEntity.ok(responseBody);
    }

    @Override
    @PostMapping("/signIn")
    public ResponseEntity<Token> signIn(Login login) {
        return ResponseEntity.ok(service.logar(login));
    }

    @Override
    @GetMapping("/me")
    public ResponseEntity<Usuario> me(HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.perfil(token));
    }
}

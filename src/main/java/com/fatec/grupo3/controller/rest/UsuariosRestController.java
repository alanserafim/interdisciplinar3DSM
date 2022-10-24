package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.UsuariosRestControllerDocs;
import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.SignUpDTO;
import com.fatec.grupo3.model.dto.TokenDTO;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = {"https://alanserafim.github.io/fatecflix-angular/", "http://localhost:4200/"})
@RequestMapping("/api/v1/usuarios")
public class UsuariosRestController implements UsuariosRestControllerDocs {

    @Autowired
    private UsuariosService service;

    @Override
    @PostMapping("/signUp")
    public ResponseEntity<SignUpDTO> signUp(SignUpDTO usuarioDto) {
        SignUpDTO responseBody = service.cadastrar(usuarioDto);

        return ResponseEntity.ok(responseBody);
    }

    @Override
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(LoginDTO loginDTO) {
        return ResponseEntity.ok(service.logar(loginDTO));
    }

    @Override
    @GetMapping("/me")
    public ResponseEntity<SignUpDTO> me(HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.perfil(token));
    }
}

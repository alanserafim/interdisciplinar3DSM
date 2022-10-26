package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.UsuariosRestControllerDocs;
import com.fatec.grupo3.model.dto.ListaDTO;
import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.dto.TokenDTO;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/usuarios")
public class UsuariosRestController implements UsuariosRestControllerDocs {

    @Autowired
    private UsuariosService service;

    @Override
    @PostMapping("/signUp")
    public ResponseEntity<UsuarioDTO> signUp(UsuarioDTO usuarioDto) {
        UsuarioDTO responseBody = service.cadastrar(usuarioDto);

        return ResponseEntity.ok(responseBody);
    }

    @Override
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(LoginDTO loginDTO) {
        return ResponseEntity.ok(service.logar(loginDTO));
    }

    @Override
    @GetMapping("/me")
    public ResponseEntity<UsuarioDTO> me(HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.perfil(token));
    }

	@Override
    @PostMapping("/me")
	public ResponseEntity<Optional<UsuarioDTO>> updateUsuario(HttpServletRequest request,
                                                              @Valid UsuarioDTO usuarioDto) throws Exception {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.atualizarPerfil(token, usuarioDto));
	}

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<Optional<UsuarioDTO>> updateOutroUsuario(@PathVariable("id") Long id, HttpServletRequest request, UsuarioDTO usuarioDto) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.atualizarPerfilDeOutroUsuario(id,token, usuarioDto));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ListaDTO>> consultarUsuarios(HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.consultarUsuarios(token));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable("id") Long id, HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        service.deletarUsuario(id, token);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> consultarUsuario(@PathVariable("id") Long id, HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.consultarUsuarioPeloId(id, token));
    }
}

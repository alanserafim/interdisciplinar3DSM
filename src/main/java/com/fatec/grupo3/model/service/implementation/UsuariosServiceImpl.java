package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Token;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Usuario cadastrar(Usuario usuario) {
        String pwd = usuario.getPassword();
        usuario.setPassword(new BCryptPasswordEncoder().encode(pwd));

        return usuariosRepository.save(usuario);
    }

    @Override
    public Token logar(Login login) {
        UsernamePasswordAuthenticationToken loginData = login.convert();
        Authentication auth = authenticationManager.authenticate(loginData);
        String token = tokenService.getToken(auth);

        return new Token(token, "Bearer");
    }

    @Override
    public Usuario perfil(String token) {
        Long userId = tokenService.getUserId(token);

        return usuariosRepository.getReferenceById(userId);
    }
}

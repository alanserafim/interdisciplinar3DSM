package com.fatec.grupo3.security;

import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.model.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuariosService service;

    @Autowired
    private UsuariosRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username);

        if (usuario == null) {
            usuario = repository.findByUsername(username);
        }

        if (!validUser(usuario)) {
            throw new UsernameNotFoundException("Usuario sem permissão");
        }

        return usuario;
    }

    private boolean validUser(Usuario usuario) {
        boolean validUser = false;

        if (usuario != null && usuario.getRoles() != null) {
            validUser = true;
        }

        return validUser;
    }
}

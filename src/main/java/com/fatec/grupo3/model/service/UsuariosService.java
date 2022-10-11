package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Token;
import com.fatec.grupo3.model.entities.Usuario;

public interface UsuariosService {

    Usuario cadastrar(Usuario usuario);
    Token logar(Login login);
    Usuario perfil(String token);
}

package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.ProfileDTO;
import com.fatec.grupo3.model.dto.SignUpDTO;
import com.fatec.grupo3.model.dto.TokenDTO;
import com.fatec.grupo3.model.entities.Usuario;

public interface UsuariosService {

    SignUpDTO cadastrar(SignUpDTO usuarioDto);
    TokenDTO logar(LoginDTO loginDTO);
    SignUpDTO perfil(String token);
    SignUpDTO atualizarPerfil(String token, SignUpDTO usuarioDto);
}

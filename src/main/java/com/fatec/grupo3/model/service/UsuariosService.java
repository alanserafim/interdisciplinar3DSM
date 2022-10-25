package com.fatec.grupo3.model.service;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.SignUpDTO;
import com.fatec.grupo3.model.dto.TokenDTO;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {

    SignUpDTO cadastrar(SignUpDTO usuarioDto);
    TokenDTO logar(LoginDTO loginDTO);
    SignUpDTO perfil(String token);
    Optional<SignUpDTO> atualizarPerfil(String token, SignUpDTO usuarioDto);
    List<SignUpDTO> consultarUsuarios(String token) throws AreaProibidaException;
    Optional<SignUpDTO> atualizarPerfilDeOutroUsuario(Long id, String token, SignUpDTO usuarioDto) throws AreaProibidaException;
    void deletarUsuario(Long id, String token) throws AreaProibidaException;
}

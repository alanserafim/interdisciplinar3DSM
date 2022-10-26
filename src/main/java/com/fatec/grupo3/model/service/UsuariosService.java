package com.fatec.grupo3.model.service;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.ListaDTO;
import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.dto.TokenDTO;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {

    UsuarioDTO cadastrar(UsuarioDTO usuarioDto);
    TokenDTO logar(LoginDTO loginDTO);
    UsuarioDTO perfil(String token);
    Optional<UsuarioDTO> atualizarPerfil(String token, UsuarioDTO usuarioDto);
    UsuarioDTO consultarUsuarioPeloId(Long id, String token) throws AreaProibidaException;
    List<ListaDTO> consultarUsuarios(String token) throws AreaProibidaException;
    Optional<UsuarioDTO> atualizarPerfilDeOutroUsuario(Long id, String token, UsuarioDTO usuarioDto) throws AreaProibidaException;
    void deletarUsuario(Long id, String token) throws AreaProibidaException;
}

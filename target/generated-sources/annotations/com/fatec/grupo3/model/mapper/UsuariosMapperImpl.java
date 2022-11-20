package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ListaDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T11:41:45-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class UsuariosMapperImpl implements UsuariosMapper {

    @Override
    public Usuario toModel(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setDtNascimento( usuarioDTO.getDtNascimento() );
        usuario.setRa( usuarioDTO.getRa() );
        usuario.setCursoMatriculado( usuarioDTO.getCursoMatriculado() );
        usuario.setAnoIngresso( usuarioDTO.getAnoIngresso() );
        usuario.setPeriodo( usuarioDTO.getPeriodo() );
        usuario.setUsername( usuarioDTO.getUsername() );
        usuario.setCpf( usuarioDTO.getCpf() );
        usuario.setPassword( usuarioDTO.getPassword() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setName( usuarioDTO.getName() );
        usuario.setLastname( usuarioDTO.getLastname() );
        List<String> list = usuarioDTO.getRoles();
        if ( list != null ) {
            usuario.setRoles( new ArrayList<String>( list ) );
        }

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String dtNascimento = null;
        Long ra = null;
        String cursoMatriculado = null;
        String anoIngresso = null;
        String periodo = null;
        String username = null;
        String email = null;
        String cpf = null;
        String password = null;
        String name = null;
        String lastname = null;
        List<String> roles = null;

        dtNascimento = usuario.getDtNascimento();
        ra = usuario.getRa();
        cursoMatriculado = usuario.getCursoMatriculado();
        anoIngresso = usuario.getAnoIngresso();
        periodo = usuario.getPeriodo();
        username = usuario.getUsername();
        email = usuario.getEmail();
        cpf = usuario.getCpf();
        password = usuario.getPassword();
        name = usuario.getName();
        lastname = usuario.getLastname();
        List<String> list = usuario.getRoles();
        if ( list != null ) {
            roles = new ArrayList<String>( list );
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO( username, email, cpf, password, name, lastname, roles, dtNascimento, ra, cursoMatriculado, anoIngresso, periodo );

        return usuarioDTO;
    }

    @Override
    public ListaDTO toListaDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String cpf = null;
        String password = null;
        String name = null;
        String lastname = null;
        List<String> roles = null;
        String dtNascimento = null;
        Integer ra = null;
        String cursoMatriculado = null;
        String anoIngresso = null;
        String periodo = null;
        Long userId = null;
        String username = null;
        String email = null;

        cpf = usuario.getCpf();
        password = usuario.getPassword();
        name = usuario.getName();
        lastname = usuario.getLastname();
        List<String> list = usuario.getRoles();
        if ( list != null ) {
            roles = new ArrayList<String>( list );
        }
        dtNascimento = usuario.getDtNascimento();
        if ( usuario.getRa() != null ) {
            ra = usuario.getRa().intValue();
        }
        cursoMatriculado = usuario.getCursoMatriculado();
        anoIngresso = usuario.getAnoIngresso();
        periodo = usuario.getPeriodo();
        userId = usuario.getUserId();
        username = usuario.getUsername();
        email = usuario.getEmail();

        ListaDTO listaDTO = new ListaDTO( userId, username, email, cpf, password, name, lastname, roles, dtNascimento, ra, cursoMatriculado, anoIngresso, periodo );

        return listaDTO;
    }
}

package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ListaDTO;
import com.fatec.grupo3.model.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T08:22:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ListaUsuariosMapperImpl implements ListaUsuariosMapper {

    @Override
    public Usuario toModel(ListaDTO listaDTO) {
        if ( listaDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setDtNascimento( listaDTO.getDtNascimento() );
        if ( listaDTO.getRa() != null ) {
            usuario.setRa( listaDTO.getRa().longValue() );
        }
        usuario.setCursoMatriculado( listaDTO.getCursoMatriculado() );
        usuario.setAnoIngresso( listaDTO.getAnoIngresso() );
        usuario.setPeriodo( listaDTO.getPeriodo() );
        usuario.setUserId( listaDTO.getUserId() );
        usuario.setUsername( listaDTO.getUsername() );
        usuario.setCpf( listaDTO.getCpf() );
        usuario.setPassword( listaDTO.getPassword() );
        usuario.setEmail( listaDTO.getEmail() );
        usuario.setName( listaDTO.getName() );
        usuario.setLastname( listaDTO.getLastname() );
        List<String> list = listaDTO.getRoles();
        if ( list != null ) {
            usuario.setRoles( new ArrayList<String>( list ) );
        }

        return usuario;
    }

    @Override
    public ListaDTO toDTO(Usuario usuario) {
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

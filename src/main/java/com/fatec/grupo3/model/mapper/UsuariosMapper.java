package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.SignUpDTO;
import com.fatec.grupo3.model.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    UsuariosMapper INSTANCE = Mappers.getMapper(UsuariosMapper.class);

    Usuario toModel(SignUpDTO signUpDTO);

    SignUpDTO toDTO(Usuario usuario);
}

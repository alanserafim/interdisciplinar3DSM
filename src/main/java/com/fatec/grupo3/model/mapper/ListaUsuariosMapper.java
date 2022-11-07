package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ListaDTO;
import com.fatec.grupo3.model.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListaUsuariosMapper {

    ListaUsuariosMapper INSTANCE = Mappers.getMapper(ListaUsuariosMapper.class);

    Usuario toModel(ListaDTO listaDTO);

    ListaDTO toDTO(Usuario usuario);
}

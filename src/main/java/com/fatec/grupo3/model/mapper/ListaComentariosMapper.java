package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ComentariosDTO;
import com.fatec.grupo3.model.entities.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListaComentariosMapper {
    ListaComentariosMapper INSTANCE = Mappers.getMapper(ListaComentariosMapper.class);

    Comentario toModel(ComentariosDTO dto);
    ComentariosDTO toDto(Comentario comentario);
}

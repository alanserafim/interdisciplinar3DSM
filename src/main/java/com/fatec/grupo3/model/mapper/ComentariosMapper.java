package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ComentarioDTO;
import com.fatec.grupo3.model.dto.ComentariosDTO;
import com.fatec.grupo3.model.entities.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ComentariosMapper {
    ComentariosMapper INSTANCE = Mappers.getMapper(ComentariosMapper.class);

    Comentario toModel(ComentarioDTO dto);
    ComentarioDTO toDto(Comentario model);
}

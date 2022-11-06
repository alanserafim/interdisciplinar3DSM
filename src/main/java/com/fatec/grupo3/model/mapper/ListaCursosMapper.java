package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ListaCursoDTO;
import com.fatec.grupo3.model.entities.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListaCursosMapper {
    ListaCursosMapper INSTANCE = Mappers.getMapper(ListaCursosMapper.class);

    Curso toModel(ListaCursoDTO dto);

    ListaCursoDTO toDto(Curso model);

}

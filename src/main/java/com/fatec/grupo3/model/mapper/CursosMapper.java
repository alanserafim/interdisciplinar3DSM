package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.entities.Curso;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursosMapper {

    CursosMapper INSTANCE = Mappers.getMapper(CursosMapper.class);

    Curso toModel(CursoDTO cursoDTO);

    CursoDTO toDTO(Curso curso);
}

package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatriculasMapper {

    MatriculasMapper INSTANCE = Mappers.getMapper(MatriculasMapper.class);

    Matricula toModel(MatriculaDTO matriculaDTO);

    MatriculaDTO toDTO(Matricula matricula);
}

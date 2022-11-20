package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.MatriculasDTO;
import com.fatec.grupo3.model.entities.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListaMatriculasMapper {
    ListaMatriculasMapper INSTANCE = Mappers.getMapper(ListaMatriculasMapper.class);

    Matricula toModel(MatriculasDTO dto);
    MatriculasDTO toDto(Matricula model);
}

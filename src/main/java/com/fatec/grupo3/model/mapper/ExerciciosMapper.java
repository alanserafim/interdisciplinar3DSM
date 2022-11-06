package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.entities.Exercicio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExerciciosMapper {
    ExerciciosMapper INSTANCE = Mappers.getMapper(ExerciciosMapper.class);

    Exercicio toModel(ExercicioDTO dto);

    ExercicioDTO toDto(Exercicio model);
}

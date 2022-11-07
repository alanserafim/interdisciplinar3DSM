package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ListaExercicioDTO;
import com.fatec.grupo3.model.entities.Exercicio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListaExerciciosMapper {

    ListaExerciciosMapper INSTANCE = Mappers.getMapper(ListaExerciciosMapper.class);

    ListaExercicioDTO toDto(Exercicio model);

    Exercicio toModel(ListaExerciciosMapper dto);
}

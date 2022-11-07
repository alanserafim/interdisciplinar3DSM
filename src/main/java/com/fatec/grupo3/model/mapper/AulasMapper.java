package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.entities.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AulasMapper {

    AulasMapper INSTANCE = Mappers.getMapper(AulasMapper.class);

    Aula toModel(AulaDTO dto);

    AulaDTO toDto(Aula model);
}

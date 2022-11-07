package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.ListaAulaDTO;
import com.fatec.grupo3.model.entities.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListaAulasMapper {
    ListaAulasMapper INSTANCE = Mappers.getMapper(ListaAulasMapper.class);

    ListaAulaDTO toDTO(Aula model);

    AulaDTO toModel(ListaAulaDTO dto);
}

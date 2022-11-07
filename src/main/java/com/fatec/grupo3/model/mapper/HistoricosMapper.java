package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.HistoricoDTO;
import com.fatec.grupo3.model.entities.Historico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HistoricosMapper {
    HistoricosMapper INSTANCE = Mappers.getMapper(HistoricosMapper.class);

    HistoricoDTO toDto(Historico model);
    Historico toModel(HistoricoDTO dto);
}

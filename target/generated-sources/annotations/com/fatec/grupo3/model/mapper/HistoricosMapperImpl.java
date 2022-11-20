package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.HistoricoDTO;
import com.fatec.grupo3.model.entities.Historico;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T08:22:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class HistoricosMapperImpl implements HistoricosMapper {

    @Override
    public HistoricoDTO toDto(Historico model) {
        if ( model == null ) {
            return null;
        }

        HistoricoDTO historicoDTO = new HistoricoDTO();

        historicoDTO.setHistoricoId( model.getHistoricoId() );
        historicoDTO.setNomeCurso( model.getNomeCurso() );
        historicoDTO.setDuracaoCurso( model.getDuracaoCurso() );
        historicoDTO.setNota( model.getNota() );

        return historicoDTO;
    }

    @Override
    public Historico toModel(HistoricoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Historico historico = new Historico();

        historico.setHistoricoId( dto.getHistoricoId() );
        historico.setNomeCurso( dto.getNomeCurso() );
        historico.setDuracaoCurso( dto.getDuracaoCurso() );
        historico.setNota( dto.getNota() );

        return historico;
    }
}

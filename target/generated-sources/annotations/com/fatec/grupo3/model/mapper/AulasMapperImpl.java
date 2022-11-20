package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.entities.Aula;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T08:22:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class AulasMapperImpl implements AulasMapper {

    @Override
    public Aula toModel(AulaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aula aula = new Aula();

        aula.setTitulo( dto.getTitulo() );
        aula.setVideo( dto.getVideo() );
        aula.setConteudo( dto.getConteudo() );

        return aula;
    }

    @Override
    public AulaDTO toDto(Aula model) {
        if ( model == null ) {
            return null;
        }

        AulaDTO aulaDTO = new AulaDTO();

        aulaDTO.setTitulo( model.getTitulo() );
        aulaDTO.setVideo( model.getVideo() );
        aulaDTO.setConteudo( model.getConteudo() );

        return aulaDTO;
    }
}

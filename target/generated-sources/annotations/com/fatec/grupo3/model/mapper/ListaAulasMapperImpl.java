package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.ListaAulaDTO;
import com.fatec.grupo3.model.entities.Aula;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T11:41:44-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ListaAulasMapperImpl implements ListaAulasMapper {

    @Override
    public ListaAulaDTO toDTO(Aula model) {
        if ( model == null ) {
            return null;
        }

        Long aulaId = null;
        String titulo = null;
        String video = null;
        String conteudo = null;

        aulaId = model.getAulaId();
        titulo = model.getTitulo();
        video = model.getVideo();
        conteudo = model.getConteudo();

        ListaAulaDTO listaAulaDTO = new ListaAulaDTO( aulaId, titulo, video, conteudo );

        return listaAulaDTO;
    }

    @Override
    public AulaDTO toModel(ListaAulaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AulaDTO aulaDTO = new AulaDTO();

        aulaDTO.setTitulo( dto.getTitulo() );
        aulaDTO.setVideo( dto.getVideo() );
        aulaDTO.setConteudo( dto.getConteudo() );

        return aulaDTO;
    }
}

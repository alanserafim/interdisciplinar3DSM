package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ComentariosDTO;
import com.fatec.grupo3.model.entities.Comentario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T11:41:45-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ListaComentariosMapperImpl implements ListaComentariosMapper {

    @Override
    public Comentario toModel(ComentariosDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setComentario( dto.getComentario() );

        return comentario;
    }

    @Override
    public ComentariosDTO toDto(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        ComentariosDTO comentariosDTO = new ComentariosDTO();

        comentariosDTO.setComentario( comentario.getComentario() );

        return comentariosDTO;
    }
}

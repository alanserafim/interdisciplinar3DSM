package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ComentarioDTO;
import com.fatec.grupo3.model.entities.Comentario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T12:30:01-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ComentariosMapperImpl implements ComentariosMapper {

    @Override
    public Comentario toModel(ComentarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setComentario( dto.getComentario() );

        return comentario;
    }

    @Override
    public ComentarioDTO toDto(Comentario model) {
        if ( model == null ) {
            return null;
        }

        ComentarioDTO comentarioDTO = new ComentarioDTO();

        comentarioDTO.setComentario( model.getComentario() );

        return comentarioDTO;
    }
}

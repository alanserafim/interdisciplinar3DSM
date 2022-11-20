package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.entities.Exercicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T10:31:52-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ExerciciosMapperImpl implements ExerciciosMapper {

    @Override
    public Exercicio toModel(ExercicioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Exercicio exercicio = new Exercicio();

        exercicio.setTitulo( dto.getTitulo() );
        exercicio.setEnunciado( dto.getEnunciado() );
        List<String> list = dto.getAfirmativas();
        if ( list != null ) {
            exercicio.setAfirmativas( new ArrayList<String>( list ) );
        }
        exercicio.setResposta( dto.getResposta() );

        return exercicio;
    }

    @Override
    public ExercicioDTO toDto(Exercicio model) {
        if ( model == null ) {
            return null;
        }

        ExercicioDTO exercicioDTO = new ExercicioDTO();

        exercicioDTO.setTitulo( model.getTitulo() );
        exercicioDTO.setEnunciado( model.getEnunciado() );
        List<String> list = model.getAfirmativas();
        if ( list != null ) {
            exercicioDTO.setAfirmativas( new ArrayList<String>( list ) );
        }
        exercicioDTO.setResposta( model.getResposta() );

        return exercicioDTO;
    }
}

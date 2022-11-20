package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.ListaExercicioDTO;
import com.fatec.grupo3.model.entities.Exercicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T10:31:53-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ListaExerciciosMapperImpl implements ListaExerciciosMapper {

    @Override
    public ListaExercicioDTO toDto(Exercicio model) {
        if ( model == null ) {
            return null;
        }

        Long exercicioId = null;
        String titulo = null;
        String enunciado = null;
        List<String> afirmativas = null;
        String resposta = null;

        exercicioId = model.getExercicioId();
        titulo = model.getTitulo();
        enunciado = model.getEnunciado();
        List<String> list = model.getAfirmativas();
        if ( list != null ) {
            afirmativas = new ArrayList<String>( list );
        }
        resposta = model.getResposta();

        ListaExercicioDTO listaExercicioDTO = new ListaExercicioDTO( exercicioId, titulo, enunciado, afirmativas, resposta );

        return listaExercicioDTO;
    }

    @Override
    public Exercicio toModel(ListaExerciciosMapper dto) {
        if ( dto == null ) {
            return null;
        }

        Exercicio exercicio = new Exercicio();

        return exercicio;
    }
}

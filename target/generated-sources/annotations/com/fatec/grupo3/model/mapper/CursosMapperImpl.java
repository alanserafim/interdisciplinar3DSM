package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Exercicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T08:22:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CursosMapperImpl implements CursosMapper {

    @Override
    public Curso toModel(CursoDTO cursoDTO) {
        if ( cursoDTO == null ) {
            return null;
        }

        Curso curso = new Curso();

        curso.setTitulo( cursoDTO.getTitulo() );
        curso.setDescricao( cursoDTO.getDescricao() );
        curso.setCargaHorario( cursoDTO.getCargaHorario() );
        curso.setDataAtualizacao( cursoDTO.getDataAtualizacao() );
        curso.setMediaAvaliacao( cursoDTO.getMediaAvaliacao() );
        curso.setCategoria( cursoDTO.getCategoria() );

        return curso;
    }

    @Override
    public CursoDTO toDTO(Curso curso) {
        if ( curso == null ) {
            return null;
        }

        String titulo = null;
        String descricao = null;
        String cargaHorario = null;
        String dataAtualizacao = null;
        Double mediaAvaliacao = null;
        String categoria = null;
        List<AulaDTO> aulas = null;
        List<ExercicioDTO> exercicios = null;

        titulo = curso.getTitulo();
        descricao = curso.getDescricao();
        cargaHorario = curso.getCargaHorario();
        dataAtualizacao = curso.getDataAtualizacao();
        mediaAvaliacao = curso.getMediaAvaliacao();
        categoria = curso.getCategoria();
        aulas = aulaListToAulaDTOList( curso.getAulas() );
        exercicios = exercicioListToExercicioDTOList( curso.getExercicios() );

        CursoDTO cursoDTO = new CursoDTO( titulo, descricao, cargaHorario, dataAtualizacao, mediaAvaliacao, aulas, exercicios, categoria );

        return cursoDTO;
    }

    protected AulaDTO aulaToAulaDTO(Aula aula) {
        if ( aula == null ) {
            return null;
        }

        AulaDTO aulaDTO = new AulaDTO();

        aulaDTO.setTitulo( aula.getTitulo() );
        aulaDTO.setVideo( aula.getVideo() );
        aulaDTO.setConteudo( aula.getConteudo() );

        return aulaDTO;
    }

    protected List<AulaDTO> aulaListToAulaDTOList(List<Aula> list) {
        if ( list == null ) {
            return null;
        }

        List<AulaDTO> list1 = new ArrayList<AulaDTO>( list.size() );
        for ( Aula aula : list ) {
            list1.add( aulaToAulaDTO( aula ) );
        }

        return list1;
    }

    protected ExercicioDTO exercicioToExercicioDTO(Exercicio exercicio) {
        if ( exercicio == null ) {
            return null;
        }

        ExercicioDTO exercicioDTO = new ExercicioDTO();

        exercicioDTO.setTitulo( exercicio.getTitulo() );
        exercicioDTO.setEnunciado( exercicio.getEnunciado() );
        List<String> list = exercicio.getAfirmativas();
        if ( list != null ) {
            exercicioDTO.setAfirmativas( new ArrayList<String>( list ) );
        }
        exercicioDTO.setResposta( exercicio.getResposta() );

        return exercicioDTO;
    }

    protected List<ExercicioDTO> exercicioListToExercicioDTOList(List<Exercicio> list) {
        if ( list == null ) {
            return null;
        }

        List<ExercicioDTO> list1 = new ArrayList<ExercicioDTO>( list.size() );
        for ( Exercicio exercicio : list ) {
            list1.add( exercicioToExercicioDTO( exercicio ) );
        }

        return list1;
    }
}

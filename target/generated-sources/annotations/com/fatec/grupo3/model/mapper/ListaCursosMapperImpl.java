package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.dto.ListaCursoDTO;
import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Exercicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T14:36:13-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ListaCursosMapperImpl implements ListaCursosMapper {

    @Override
    public Curso toModel(ListaCursoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Curso curso = new Curso();

        curso.setCursoId( dto.getCursoId() );
        curso.setTitulo( dto.getTitulo() );
        curso.setDescricao( dto.getDescricao() );
        curso.setCargaHorario( dto.getCargaHorario() );
        curso.setDataAtualizacao( dto.getDataAtualizacao() );
        curso.setMediaAvaliacao( dto.getMediaAvaliacao() );
        curso.setAulas( aulaDTOListToAulaList( dto.getAulas() ) );
        curso.setExercicios( exercicioDTOListToExercicioList( dto.getExercicios() ) );
        curso.setCategoria( dto.getCategoria() );

        return curso;
    }

    @Override
    public ListaCursoDTO toDto(Curso model) {
        if ( model == null ) {
            return null;
        }

        Long cursoId = null;
        String titulo = null;
        String descricao = null;
        String cargaHorario = null;
        String dataAtualizacao = null;
        Double mediaAvaliacao = null;
        List<AulaDTO> aulas = null;
        List<ExercicioDTO> exercicios = null;
        String categoria = null;

        cursoId = model.getCursoId();
        titulo = model.getTitulo();
        descricao = model.getDescricao();
        cargaHorario = model.getCargaHorario();
        dataAtualizacao = model.getDataAtualizacao();
        mediaAvaliacao = model.getMediaAvaliacao();
        aulas = aulaListToAulaDTOList( model.getAulas() );
        exercicios = exercicioListToExercicioDTOList( model.getExercicios() );
        categoria = model.getCategoria();

        ListaCursoDTO listaCursoDTO = new ListaCursoDTO( cursoId, titulo, descricao, cargaHorario, dataAtualizacao, mediaAvaliacao, categoria, aulas, exercicios );

        return listaCursoDTO;
    }

    protected Aula aulaDTOToAula(AulaDTO aulaDTO) {
        if ( aulaDTO == null ) {
            return null;
        }

        Aula aula = new Aula();

        aula.setTitulo( aulaDTO.getTitulo() );
        aula.setVideo( aulaDTO.getVideo() );
        aula.setConteudo( aulaDTO.getConteudo() );

        return aula;
    }

    protected List<Aula> aulaDTOListToAulaList(List<AulaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Aula> list1 = new ArrayList<Aula>( list.size() );
        for ( AulaDTO aulaDTO : list ) {
            list1.add( aulaDTOToAula( aulaDTO ) );
        }

        return list1;
    }

    protected Exercicio exercicioDTOToExercicio(ExercicioDTO exercicioDTO) {
        if ( exercicioDTO == null ) {
            return null;
        }

        Exercicio exercicio = new Exercicio();

        exercicio.setTitulo( exercicioDTO.getTitulo() );
        exercicio.setEnunciado( exercicioDTO.getEnunciado() );
        List<String> list = exercicioDTO.getAfirmativas();
        if ( list != null ) {
            exercicio.setAfirmativas( new ArrayList<String>( list ) );
        }
        exercicio.setResposta( exercicioDTO.getResposta() );

        return exercicio;
    }

    protected List<Exercicio> exercicioDTOListToExercicioList(List<ExercicioDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Exercicio> list1 = new ArrayList<Exercicio>( list.size() );
        for ( ExercicioDTO exercicioDTO : list ) {
            list1.add( exercicioDTOToExercicio( exercicioDTO ) );
        }

        return list1;
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

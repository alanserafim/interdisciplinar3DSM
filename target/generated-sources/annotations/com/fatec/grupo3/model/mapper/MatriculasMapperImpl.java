package com.fatec.grupo3.model.mapper;

import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Matricula;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T14:36:12-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class MatriculasMapperImpl implements MatriculasMapper {

    @Override
    public Matricula toModel(MatriculaDTO matriculaDTO) {
        if ( matriculaDTO == null ) {
            return null;
        }

        Matricula matricula = new Matricula();

        matricula.setStatus( matriculaDTO.getStatus() );
        matricula.setNota( matriculaDTO.getNota() );
        matricula.setAvaliacaoCurso( matriculaDTO.getAvaliacaoCurso() );

        return matricula;
    }

    @Override
    public MatriculaDTO toDTO(Matricula matricula) {
        if ( matricula == null ) {
            return null;
        }

        String status = null;
        Double nota = null;
        Double avaliacaoCurso = null;

        status = matricula.getStatus();
        nota = matricula.getNota();
        avaliacaoCurso = matricula.getAvaliacaoCurso();

        MatriculaDTO matriculaDTO = new MatriculaDTO( status, nota, avaliacaoCurso );

        return matriculaDTO;
    }
}

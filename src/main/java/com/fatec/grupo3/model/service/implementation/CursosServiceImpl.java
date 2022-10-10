package com.fatec.grupo3.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.repositories.CursosRepositories;
import com.fatec.grupo3.model.service.CursosService;

@Service
public class CursosServiceImpl implements CursosService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private CursosRepositories repository;

    @Override
    public List<Curso> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll();
    }

    @Override
    public Optional<Curso> consultaPorTitulo(String titulo) {
        logger.info(">>>>>> servico consultaPorTitulo chamado");
        return repository.findCursoByTitulo(titulo);
    }

    @Override
    public Optional<Curso> save(Curso curso) {

        logger.info(">>>>>> servico save chamado ");
        Optional<Curso> umCurso = consultaPorTitulo(curso.getTitulo());


        if (umCurso.isEmpty()) {
            logger.info(">>>>>> servico save - dados validos");

            return Optional.ofNullable(repository.save(curso));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Optional<Curso> atualiza(Curso curso) {

        logger.info(">>>>>> servico atualiza chamado ");
        Optional<Curso> umCurso = consultaPorTitulo(curso.getTitulo());


        if (umCurso.isEmpty()) {
            logger.info(">>>>>> servico atualiza - dados validos");
            //curso.setDataAtualizacao(new DateTime());

            return Optional.ofNullable(repository.save(curso));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Curso> consultarPorId(Long id) {
        return repository.findById(id);
    }

}

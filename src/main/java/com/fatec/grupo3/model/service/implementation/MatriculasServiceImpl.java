package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.model.entities.Cliente;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.repositories.MatriculaRepository;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.model.service.MatriculasService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculasServiceImpl implements MatriculasService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private UsuariosRepository usuariosRepository;


    @Override
    public List<Matricula> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll();
    }

    @Override
    public Optional<Matricula> consultaPorUsuario(String cpf) {
        logger.info(">>>>>> servico consultaPorTitulo chamado");

        Usuario usuario = usuariosRepository.findByCpf(cpf);

        return repository.findByUsuario(usuario);
    }

    @Override
    public Optional<Matricula> save(Matricula matricula) {
        logger.info(">>>>>> servico save chamado ");
        Optional<Matricula> umMatricula = consultaPorUsuario(matricula.getUsuario().getCpf());


        if (umMatricula.isEmpty()) {
            logger.info(">>>>>> servico save - dados validos");

            return Optional.ofNullable(repository.save(matricula));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Matricula> consultaPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Matricula> atualiza(Matricula matricula) {
        logger.info(">>>>>> servico atualiza chamado ");
        Optional<Matricula> umMatricula = consultaPorUsuario(matricula.getUsuario().getCpf());


        if (umMatricula.isEmpty()) {
            logger.info(">>>>>> servico atualiza - dados validos");
            //curso.setDataAtualizacao(new DateTime());

            return Optional.ofNullable(repository.save(matricula));
        } else {
            return Optional.empty();
        }
    }
}

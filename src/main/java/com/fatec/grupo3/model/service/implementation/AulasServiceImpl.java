package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.exception.NotFoundException;
import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.ListaAulaDTO;
import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.mapper.AulasMapper;
import com.fatec.grupo3.model.mapper.ListaAulasMapper;
import com.fatec.grupo3.model.repositories.AulasRepository;
import com.fatec.grupo3.model.repositories.CursosRepositories;
import com.fatec.grupo3.model.service.AulasService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AulasServiceImpl implements AulasService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private AulasRepository repository;

    @Autowired
    private CursosRepositories cursosRepositories;

    @Autowired
    private AulasMapper mapper = AulasMapper.INSTANCE;

    @Autowired
    private ListaAulasMapper listaAulasMapper = ListaAulasMapper.INSTANCE;

    @Override
    public List<ListaAulaDTO> consultaTodos(Long cursoId) {
        logger.info(">>>>>> servico consultaTodos chamado");

        Curso curso = cursosRepositories.getReferenceById(cursoId);

        return repository.findByCurso(curso)
                .stream()
                .map(listaAulasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AulaDTO> consultaPorTitulo(String titulo) {
        logger.info(">>>>>> servico consultaPorTitulo chamado");

        Optional<Aula> aula = repository.findByTitulo(titulo);
        return Optional.of(mapper.toDto(aula.get()));
    }

    @Override
    public Optional<AulaDTO> save(Long cursoId, AulaDTO aulaDTO) {
        Curso curso = cursosRepositories.getReferenceById(cursoId);

        Aula aula = mapper.toModel(aulaDTO);

        if(curso != null) {
            logger.info(">>>>>> servico save chamado ");
            aula.setCurso(curso);
            repository.save(aula);
        }

        return Optional.ofNullable(mapper.toDto(aula));
    }

    @Override
    public void delete(Long id) {
        Aula aula = repository.getReferenceById(id);

        repository.delete(aula);
    }

    @Override
    public Optional<AulaDTO> atualiza(Long cursoId, Long aulaId, AulaDTO aulaDTO) throws NotFoundException {
        Curso curso = cursosRepositories.getReferenceById(cursoId);

        Aula aula = mapper.toModel(aulaDTO);

        if(curso != null) {
            logger.info(">>>>>> servico save chamado ");
            aula.setCurso(curso);
            aula.setAulaId(aulaId);

            repository.save(aula);

            return Optional.ofNullable(mapper.toDto(aula));
        }

        throw new NotFoundException(cursoId);
    }

    @Override
    public Optional<AulaDTO> consultarPorId(Long id) {

        Optional<Aula> aula = repository.findById(id);

        return Optional.ofNullable(mapper.toDto(aula.get()));
    }
}

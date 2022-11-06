package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.exception.NotFoundException;
import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.dto.ListaExercicioDTO;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Exercicio;
import com.fatec.grupo3.model.mapper.ExerciciosMapper;
import com.fatec.grupo3.model.mapper.ListaExerciciosMapper;
import com.fatec.grupo3.model.repositories.CursosRepositories;
import com.fatec.grupo3.model.repositories.ExercicioRepository;
import com.fatec.grupo3.model.service.ExerciciosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExerciciosServiceImpl implements ExerciciosService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private ExercicioRepository repository;

    @Autowired
    private CursosRepositories cursosRepositories;

    @Autowired
    private ExerciciosMapper mapper = ExerciciosMapper.INSTANCE;

    @Autowired
    private ListaExerciciosMapper listaExerciciosMapper = ListaExerciciosMapper.INSTANCE;

    @Override
    public List<ListaExercicioDTO> consultaTodos(Long cursoId) {

        Curso curso = cursosRepositories.getReferenceById(cursoId);

        return repository.findByCurso(curso)
                .stream()
                .map(listaExerciciosMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ExercicioDTO> save(Long cursoId, ExercicioDTO exercicioDTO) {
        Curso curso = cursosRepositories.getReferenceById(cursoId);

        Exercicio exercicio = mapper.toModel(exercicioDTO);

        if(curso != null) {
            logger.info(">>>>>> servico save chamado ");
            exercicio.setCurso(curso);
            repository.save(exercicio);
        }

        return Optional.ofNullable(mapper.toDto(exercicio));
    }

    @Override
    public void delete(Long id) {
        Exercicio exercicio = repository.getReferenceById(id);

        repository.delete(exercicio);
    }

    @Override
    public Optional<ExercicioDTO> atualiza(Long cursoId, Long exercicioId, ExercicioDTO exercicioDTO) throws NotFoundException {
        Curso curso = cursosRepositories.getReferenceById(cursoId);

        Exercicio exercicio = mapper.toModel(exercicioDTO);
        if(curso != null) {
            logger.info(">>>>>> servico save chamado ");
            exercicio.setCurso(curso);
            exercicio.setExercicioId(exercicioId);

            repository.save(exercicio);

            return Optional.ofNullable(mapper.toDto(exercicio));
        }

        throw new NotFoundException(cursoId);
    }

    @Override
    public Optional<ExercicioDTO> consultarPorId(Long id) {
        Optional<Exercicio> exercicio = repository.findById(id);

        return Optional.ofNullable(mapper.toDto(exercicio.get()));
    }
}

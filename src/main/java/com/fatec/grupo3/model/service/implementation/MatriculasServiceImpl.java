package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.HistoricoDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.dto.MatriculasDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.entities.*;
import com.fatec.grupo3.model.mapper.HistoricosMapper;
import com.fatec.grupo3.model.mapper.ListaMatriculasMapper;
import com.fatec.grupo3.model.mapper.MatriculasMapper;
import com.fatec.grupo3.model.mapper.UsuariosMapper;
import com.fatec.grupo3.model.repositories.*;
import com.fatec.grupo3.model.service.MatriculasService;
import com.fatec.grupo3.security.TokenService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class MatriculasServiceImpl implements MatriculasService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private MatriculasMapper mapper = MatriculasMapper.INSTANCE;

    @Autowired
    private HistoricosMapper historicosMapper = HistoricosMapper.INSTANCE;


    @Autowired
    private UsuariosMapper usuariosMapper = UsuariosMapper.INSTANCE;

    @Autowired
    private ListaMatriculasMapper listaMatriculasMapper = ListaMatriculasMapper.INSTANCE;
    
    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private CursosRepositories cursosRepositories;

    @Autowired
    private HistoricosRepository historicosRepository;
    
    @Autowired
    private TokenService tokenService;

    @Override
    public List<MatriculasDTO> consultaTodos(String token) {
        logger.info(">>>>>> servico consultaTodos chamado");

        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        return repository.findAllByUsuario(usuario)
                .stream()
                .map(listaMatriculasMapper::toDto)
                .collect(Collectors.toList());
    }
    
    @Transactional
    @Override
    public Optional<MatriculaDTO> save(MatriculaDTO matricula, Long idCurso, String token) {
        logger.info(">>>>>> servico save chamado ");
        
        Long userId = tokenService.getUserId(token);
        
        Usuario usuario = usuariosRepository.getReferenceById(userId);
        Curso curso = cursosRepositories.getReferenceById(idCurso);
        
        Matricula matriculaEntity = mapper.toModel(matricula);
        
        matriculaEntity.setUsuario(usuario);
        matriculaEntity.setCurso(curso);
        repository.save(matriculaEntity);
        
        return Optional.of(matricula);
    }

    @Override
    @Transactional
    public void delete(Long id, String token) {
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        repository.deleteByUsuarioAndMatriculaId(usuario, id);
    }

    @Override
    public Optional<MatriculasDTO> consultaPorId(Long id, String token) throws AreaProibidaException {

        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

    	if (usuario.getRoles().contains("ALUNO") || usuario.getRoles().contains("ADMIN") || usuario.getRoles().contains("INSTRUTOR")) {
            Matricula matricula = repository.getReferenceById(id);
            MatriculasDTO matriculaDTO = listaMatriculasMapper.toDto(matricula);

            return Optional.of(matriculaDTO);
        }
    	
        throw new AreaProibidaException(usuario.getCpf());
    }
    
    @Transactional
    @Override
    public Optional<MatriculaDTO> atualiza(Long id, Long idCurso, Double nota, String token) throws AreaProibidaException {
        logger.info(">>>>>> servico atualiza chamado ");
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);
        Curso curso = cursosRepositories.getReferenceById(idCurso);

        Matricula matricula = repository.getReferenceById(id);


        matricula.setUsuario(usuario);
        matricula.setCurso(curso);
        matricula.setMatriculaId(id);
        matricula.setNota(nota);
        matricula.setStatus("Concluido");

        Optional<Historico> historicoFounded = historicosRepository.findByMatricula(matricula);

        if (!historicoFounded.isPresent()) {
            Historico historico = new Historico();

            historico.setMatricula(matricula);
            historico.setDuracaoCurso(curso.getCargaHorario());
            historico.setNomeCurso(curso.getTitulo());
            historico.setNota(matricula.getNota());
            historico.setEmailInstrutor(curso.getUsuario().getEmail());
            historico.setUsuario(usuario);

            historicosRepository.save(historico);
        } else {
            Historico historico = historicoFounded.get();

            historico.setMatricula(matricula);
            historico.setDuracaoCurso(curso.getCargaHorario());
            historico.setNomeCurso(curso.getTitulo());
            historico.setNota(matricula.getNota());
            historico.setEmailInstrutor(curso.getUsuario().getEmail());
            historico.setUsuario(usuario);

            historicosRepository.save(historico);
        }

        return Optional.of(mapper.toDTO(repository.save(matricula)));
    }

    @Override
    public List<HistoricoDTO> consultarHistorico(String token) {
        logger.info(">>>>>> servico consulta Historico chamado");

        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        return historicosRepository.findAllByUsuario(usuario)
                .stream()
                .map(historicosMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> consultarUsuariosMatriculados(Long cursoId) {

        return repository.findUsuariosByCursoId(cursoId)
                .stream()
                .map(usuariosMapper::toDTO)
                .collect(Collectors.toList());
    }

    /*@Override
    public List<MatriculasDTO> consultarCursoPorMatriculaId(Long id) {
        return repository.findCursoByMatriculaId(id)
                .stream()
                .map(listaMatriculasMapper::toDto)
                .collect(Collectors.toList());
    }*/


}

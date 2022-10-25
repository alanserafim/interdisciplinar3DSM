package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Cliente;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.mapper.MatriculasMapper;
import com.fatec.grupo3.model.repositories.CursosRepositories;
import com.fatec.grupo3.model.repositories.MatriculaRepository;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
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
    private CursosRepositories cursosRepository;
    
    @Autowired
    private TokenService tokenService;

    @Override
    public List<MatriculaDTO> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Transactional
    @Override
    public Optional<MatriculaDTO> save(MatriculaDTO matricula, Long idCurso, String token) {
        logger.info(">>>>>> servico save chamado ");
        
        Long userId = tokenService.getUserId(token);
        
        Usuario usuario = usuariosRepository.getReferenceById(userId);
        Curso curso = cursosRepository.getReferenceById(idCurso);
        
        Matricula matriculaEntity = mapper.toModel(matricula);
        
        matriculaEntity.setUsuario(usuario);
        matriculaEntity.setCurso(curso);
        
        Matricula matriculaSalva = repository.save(matriculaEntity);
        MatriculaDTO matriculaDTO = mapper.toDTO(matriculaSalva);
        
        return  Optional.of(matricula);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<MatriculaDTO> consultaPorId(Long id) {
    	Matricula matricula = repository.getReferenceById(id);
    	MatriculaDTO matriculaDTO = mapper.toDTO(matricula);
    	
        return Optional.of(matriculaDTO);
    }
    
    @Transactional
    @Override
    public Optional<MatriculaDTO> atualiza(Long id, MatriculaDTO matricula, String token) {
        logger.info(">>>>>> servico atualiza chamado ");
        //Optional<Matricula> umMatricula = consultaPorUsuario(matricula.getUsuario().getCpf());
        Matricula matriculaParaSalvar = mapper.toModel(matricula);
        matriculaParaSalvar.setId(id);
        
        Matricula matriculaSalva = repository.save(matriculaParaSalvar);
        
        return Optional.of(mapper.toDTO(matriculaSalva));
        
    }
}

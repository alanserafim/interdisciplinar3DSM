package com.fatec.grupo3.model.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.ListaCursoDTO;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.security.TokenService;
import com.fatec.grupo3.model.mapper.CursosMapper;
import com.fatec.grupo3.model.mapper.ListaCursosMapper;
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

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CursosMapper mapper = CursosMapper.INSTANCE;

    @Autowired
    private ListaCursosMapper listaCursosMapper = ListaCursosMapper.INSTANCE;

    @Override
    public List<ListaCursoDTO> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");

        return repository.findAll()
                .stream()
                .map(listaCursosMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CursoDTO> consultaPorTitulo(String titulo) {
        logger.info(">>>>>> servico consultaPorTitulo chamado");
        Optional<Curso> curso = repository.findCursoByTitulo(titulo);
        return Optional.of(mapper.toDTO(curso.get()));
    }
    
    @Transactional
    @Override
    public Optional<CursoDTO> save(CursoDTO cursoDTO, String token) {
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        Curso curso = mapper.toModel(cursoDTO);

        curso.setUsuario(usuario);
        Curso cursoSalvo = repository.save(curso);

        logger.info(">>>>>> servico save chamado ");

        return Optional.ofNullable(mapper.toDTO(cursoSalvo));
    }

    @Override
    @Transactional
    public void delete(Long id, String token) {
        Long userId = tokenService.getUserId(token);
        Usuario usuario = usuariosRepository.getReferenceById(userId);

        repository.deleteByUsuarioAndCursoId(usuario, id);
    }

    @Override
    @Transactional
    public Optional<CursoDTO> atualiza(Long id, CursoDTO cursoDTO, String token) {
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);
        
        Curso curso = mapper.toModel(cursoDTO);

        curso.setCursoId(id);
        curso.setUsuario(usuario);
        Curso cursoSalvo = repository.save(curso);

        logger.info(">>>>>> servico atualiza chamado ");

        return Optional.ofNullable(mapper.toDTO(cursoSalvo));
    }

    @Override
    public Optional<CursoDTO> consultarPorId(Long id, String token) throws AreaProibidaException {
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        if (usuario.getRoles().contains("INSTRUTOR") || usuario.getRoles().contains("ALUNO") || usuario.getRoles().contains("ADMIN")) {
            Optional<Curso> curso = repository.findById(id);
            return Optional.of(mapper.toDTO(curso.get()));
        }

        throw new AreaProibidaException(usuario.getCpf());
    }

}

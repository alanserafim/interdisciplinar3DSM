package com.fatec.grupo3.model.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.SignUpDTO;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.mapper.CursosMapper;
import com.fatec.grupo3.model.mapper.UsuariosMapper;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.security.TokenService;
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
    private UsuariosMapper usuariosMapper = UsuariosMapper.INSTANCE;

    @Override
    public List<CursoDTO> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CursoDTO> consultaPorTitulo(String titulo) {
        logger.info(">>>>>> servico consultaPorTitulo chamado");
        Optional<Curso> curso = repository.findCursoByTitulo(titulo);
        return Optional.of(mapper.toDTO(curso.get()));
    }

    @Override
    public Optional<CursoDTO> save(CursoDTO cursoDTO, String token) {
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        Curso curso = mapper.toModel(cursoDTO);
        curso.setUsuario(usuario);
        Curso cursoSalvo = repository.save(curso);

        SignUpDTO usuarioLogado = usuariosMapper.toDTO(usuario);

        logger.info(">>>>>> servico save chamado ");


        return Optional.ofNullable(mapper.toDTO(cursoSalvo));
    }

    @Override
    public void delete(Long id, String token) {
        Long userId = tokenService.getUserId(token);
        Usuario usuario = usuariosRepository.getReferenceById(userId);

        if (usuario != null) {
            repository.deleteById(id);
        }
    }

    @Override
    public Optional<CursoDTO> atualiza(CursoDTO cursoDTO, String token) {
        Long userId = tokenService.getUserId(token);

        Usuario usuario = usuariosRepository.getReferenceById(userId);

        Curso curso = mapper.toModel(cursoDTO);
        curso.setUsuario(usuario);
        Curso cursoSalvo = repository.save(curso);

        SignUpDTO usuarioLogado = usuariosMapper.toDTO(usuario);

        logger.info(">>>>>> servico atualiza chamado ");

        return Optional.ofNullable(mapper.toDTO(cursoSalvo));
    }

    @Override
    public Optional<CursoDTO> consultarPorId(Long id) {
        Optional<Curso> curso = repository.findById(id);
        return Optional.of(mapper.toDTO(curso.get()));
    }

}

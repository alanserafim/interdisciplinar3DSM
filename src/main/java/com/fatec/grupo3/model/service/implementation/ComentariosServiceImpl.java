package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.model.dto.ComentarioDTO;
import com.fatec.grupo3.model.dto.ComentariosDTO;
import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.entities.Comentario;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.mapper.ComentariosMapper;
import com.fatec.grupo3.model.mapper.ListaComentariosMapper;
import com.fatec.grupo3.model.repositories.AulasRepository;
import com.fatec.grupo3.model.repositories.ComentariosRepositories;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.model.service.ComentariosService;
import com.fatec.grupo3.security.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private ComentariosRepositories repository;

    @Autowired
    private AulasRepository aulasRepository;

    @Autowired
    private ComentariosMapper mapper = ComentariosMapper.INSTANCE;

    @Autowired
    private ListaComentariosMapper listaComentariosMapper = ListaComentariosMapper.INSTANCE;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TokenService tokenService;


    @Override
    public List<ComentariosDTO> consultaTodos(Long aulaId) {
        logger.info(">>>>>> servico consultaTodos chamado");

        return repository.findAllByAula(aulaId);
    }

    @Override
    public Optional<ComentarioDTO> save(ComentarioDTO comentarioDTO, Long aulaId, String token) {
        Long userId = tokenService.getUserId(token);
        Usuario usuario = usuariosRepository.getReferenceById(userId);

        Aula aulaFounded = aulasRepository.getReferenceById(aulaId);


        Comentario comentario = mapper.toModel(comentarioDTO);

        comentario.setUsuario(usuario);
        comentario.setAula(aulaFounded);
        Comentario comentarioSalvo = repository.save(comentario);

        logger.info(">>>>>> servico save chamado ");

        return Optional.ofNullable(mapper.toDto(comentarioSalvo));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<ComentarioDTO> atualiza(Long id, Long aulaId, ComentarioDTO comentarioDTO, String token) {
        Long userId = tokenService.getUserId(token);
        Usuario usuario = usuariosRepository.getReferenceById(userId);

        Aula aulaFounded = aulasRepository.getReferenceById(aulaId);

        Comentario comentario = mapper.toModel(comentarioDTO);
        comentario.setComentarioId(id);
        comentario.setAula(aulaFounded);
        comentario.setUsuario(usuario);

        Comentario comentarioSalvo = repository.save(comentario);

        logger.info(">>>>>> servico atualiza chamado ");

        return Optional.ofNullable(mapper.toDto(comentarioSalvo));
    }
}

package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.ListaDTO;
import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.dto.TokenDTO;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.mapper.ListaUsuariosMapper;
import com.fatec.grupo3.model.mapper.UsuariosMapper;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosMapper mapper = UsuariosMapper.INSTANCE;

    @Autowired
    private ListaUsuariosMapper listaUsuariosMapper = ListaUsuariosMapper.INSTANCE;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UsuarioDTO cadastrar(UsuarioDTO usuarioDto) {
        Usuario usuario = mapper.toModel(usuarioDto);

        String pwd = usuario.getPassword();
        usuario.setPassword(new BCryptPasswordEncoder().encode(pwd));

        Usuario usuarioSalvo = usuariosRepository.save(usuario);

        return mapper.toDTO(usuarioSalvo);
    }

    @Override
    public TokenDTO logar(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken loginData = loginDTO.convert();
        Authentication auth = authenticationManager.authenticate(loginData);
        String token = tokenService.getToken(auth);

        return new TokenDTO(token, "Bearer");
    }

    @Override
    public UsuarioDTO perfil(String token) {
        Long userId = tokenService.getUserId(token);
        Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);
        return mapper.toDTO(usuarioEncontrado);
    }

	@Override
	public Optional<UsuarioDTO> atualizarPerfil(String token, UsuarioDTO usuarioDTO) {
		Long userId = tokenService.getUserId(token);
		
		Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);
		Usuario usuarioAtualizado = mapper.toModel(usuarioDTO);
		
		usuarioEncontrado.setCpf(usuarioAtualizado.getCpf());
		usuarioEncontrado.setName(usuarioAtualizado.getName());
		usuarioEncontrado.setLastname(usuarioAtualizado.getLastname());
		usuarioEncontrado.setUsername(usuarioAtualizado.getUsername());
		usuarioEncontrado.setPassword(usuarioAtualizado.getPassword());
		usuarioEncontrado.setDtNascimento(usuarioAtualizado.getDtNascimento());
		usuarioEncontrado.setRa(usuarioAtualizado.getRa());
		usuarioEncontrado.setCursoMatriculado(usuarioAtualizado.getCursoMatriculado());
		usuarioEncontrado.setAnoIngresso(usuarioAtualizado.getAnoIngresso());
		usuarioEncontrado.setPeriodo(usuarioAtualizado.getPeriodo());

		Usuario usuarioSalvo = usuariosRepository.save(usuarioEncontrado);

        UsuarioDTO dto = mapper.toDTO(usuarioSalvo);

		return Optional.of(dto);
	}

    @Override
    public UsuarioDTO consultarUsuarioPeloId(Long id, String token) throws AreaProibidaException {
        Long userId = tokenService.getUserId(token);

        Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);

        if (usuarioEncontrado.getRoles().contains("ADMIN")) {
            Usuario usuarioConsultado = usuariosRepository.getReferenceById(id);

            return mapper.toDTO(usuarioConsultado);
        }

        throw new AreaProibidaException(usuarioEncontrado.getCpf());
    }

    @Override
    public List<ListaDTO> consultarUsuarios(String token) throws AreaProibidaException {
        Long userId = tokenService.getUserId(token);

        Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);

        if (usuarioEncontrado.getRoles().contains("ADMIN")) {

            return usuariosRepository.findAll()
                    .stream()
                    .map(listaUsuariosMapper::toDTO)
                    .collect(Collectors.toList());
        }



        throw new AreaProibidaException(usuarioEncontrado.getCpf());
    }

    @Override
    public Optional<UsuarioDTO> atualizarPerfilDeOutroUsuario(Long id, String token, UsuarioDTO usuarioDto) throws AreaProibidaException {
        Long userId = tokenService.getUserId(token);

        Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);

        if (usuarioEncontrado.getRoles().contains("ADMIN")) {
            Usuario usuarioParaAtualizar = usuariosRepository.getReferenceById(id);

            usuarioParaAtualizar.setCpf(usuarioDto.getCpf());
            usuarioParaAtualizar.setName(usuarioDto.getName());
            usuarioParaAtualizar.setLastname(usuarioDto.getLastname());
            usuarioParaAtualizar.setUsername(usuarioDto.getUsername());
            usuarioParaAtualizar.setPassword(usuarioDto.getPassword());
            usuarioParaAtualizar.setDtNascimento(usuarioDto.getDtNascimento());
            usuarioParaAtualizar.setRa(usuarioDto.getRa());
            usuarioParaAtualizar.setCursoMatriculado(usuarioDto.getCursoMatriculado());
            usuarioParaAtualizar.setAnoIngresso(usuarioDto.getAnoIngresso());
            usuarioParaAtualizar.setPeriodo(usuarioDto.getPeriodo());
            usuarioParaAtualizar.setRoles(usuarioDto.getRoles());
            usuarioParaAtualizar.setUserId(id);

            Usuario usuarioSalvo = usuariosRepository.save(usuarioParaAtualizar);

            return Optional.of(mapper.toDTO(usuarioSalvo));
        }

        throw new AreaProibidaException(usuarioEncontrado.getCpf());
    }

    @Override
    public void deletarUsuario(Long id, String token) throws AreaProibidaException {
        Long userId = tokenService.getUserId(token);

        Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);

        if (usuarioEncontrado.getRoles().contains("ADMIN")) {
            usuariosRepository.deleteById(id);
        } else {
            throw new AreaProibidaException(usuarioEncontrado.getCpf());
        }
    }
}

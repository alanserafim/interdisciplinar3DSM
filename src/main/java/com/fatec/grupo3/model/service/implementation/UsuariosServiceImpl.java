package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.ProfileDTO;
import com.fatec.grupo3.model.dto.SignUpDTO;
import com.fatec.grupo3.model.dto.TokenDTO;
import com.fatec.grupo3.model.entities.Usuario;
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

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosMapper mapper = UsuariosMapper.INSTANCE;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public SignUpDTO cadastrar(SignUpDTO usuarioDto) {
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
    public SignUpDTO perfil(String token) {
        Long userId = tokenService.getUserId(token);
        Usuario usuarioEncontrado = usuariosRepository.getReferenceById(userId);
        return mapper.toDTO(usuarioEncontrado);
    }

	@Override
	public SignUpDTO atualizarPerfil(String token, SignUpDTO usuarioDTO) {
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
		usuarioEncontrado.setRoles(usuarioAtualizado.getRoles());
		
		Usuario usuarioSalvo = usuariosRepository.save(usuarioEncontrado);
		
		return mapper.toDTO(usuarioSalvo);
	}
}

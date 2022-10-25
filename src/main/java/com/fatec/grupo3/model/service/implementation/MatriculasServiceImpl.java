package com.fatec.grupo3.model.service.implementation;

import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Cliente;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.repositories.MatriculaRepository;
import com.fatec.grupo3.model.repositories.UsuariosRepository;
import com.fatec.grupo3.model.repositories.CursosRepositories;
import com.fatec.grupo3.model.service.MatriculasService;
import com.fatec.grupo3.model.service.UsuariosService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class MatriculasServiceImpl implements MatriculasService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private CursosRepositories cursoRepository;

	@Autowired
	private UsuariosRepository usuariosRepository;

	@Autowired
	private UsuariosServiceImpl usuariosService;

	@Override
	public Optional<Matricula> consultaPorId(Long id) {
		return matriculaRepository.findById(id);
	}

	public List<Matricula> findByCpf(String cpf) {
		return matriculaRepository.findByCpf(cpf);
	}

	@Transactional
	public Matricula save(Matricula matricula) {
		logger.info(">>>>>> servico save chamado " + matricula.toString());
		Matricula umMatricula = matriculaRepository.save(matricula);
		umMatricula.setUsuario(usuariosRepository.findByCpf(matricula.getUsuario().getCpf()));

		logger.info("Cabeçalho foi salvo");
		return umMatricula;

	}

	@Override
	public List<Matricula> consultaTodos() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return matriculaRepository.findAll();
	}

	/*
	 * Optional<Matricula> umMatricula = repository.findById(matricula.getId());
	 * 
	 * 
	 * if (umMatricula.isEmpty()) {
	 * logger.info(">>>>>> servico save - dados validos");
	 * 
	 * return Optional.ofNullable(repository.save(matricula)); } else { return
	 * Optional.empty(); }
	 */

	@Override
	public void delete(Long id) {
		matriculaRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Matricula cadastrarMatricula(MatriculaDTO matriculaDTO)

	{
		logger.info("Cadrasto de pedido");
		try {
			Optional<Matricula> umMatricula = obtemMatricula(matriculaDTO);
			if (umMatricula.isPresent()) {
				logger.info("Dados da Matricula são válidos");
				return save(umMatricula.get());
			} else {
				logger.info("Dados da matricula invalidos");
				return null;
			}
		} catch (Exception e) {
			logger.info(">>>>>> servico cadastrar pedido - erro nao esperado contate o administrador ");
			logger.info(">>>>>> servico cadastrar pedido - erro nao esperado => " + e.getMessage());
			return null;
		}

	}

	public Optional<Matricula> obtemMatricula(MatriculaDTO matriculaDTO) {
		Matricula matricula = new Matricula();
		Usuario usuario = new Usuario();
		Curso curso;
		
		
			if ((cpfValido(matriculaDTO.getUsuario().getCpf())) && (cursoValido(matriculaDTO.getCurso().getId()))) {
				matricula.setUsuario(usuario);
				
				Optional<Curso> umCurso = cursoRepository.findById(matriculaDTO.getCurso().getId());
				curso = umCurso.get();
				
				
			}
		
		return Optional.ofNullable(matricula);
	}

	@Override
	public Optional<Matricula> atualiza(Matricula matricula) {
		logger.info(">>>>>> servico atualiza chamado ");
		// Optional<Matricula> umMatricula =
		// consultaPorUsuario(matricula.getUsuario().getCpf());
		Optional<Matricula> umMatricula = matriculaRepository.findById(matricula.getId());

		if (umMatricula.isEmpty()) {
			logger.info(">>>>>> servico atualiza - dados validos");
			// curso.setDataAtualizacao(new DateTime());

			return Optional.ofNullable(matriculaRepository.save(matricula));
		} else {
			return Optional.empty();
		}
	}

	public boolean cpfValido(String cpf) {
		return usuariosRepository.findByCpfOptional(cpf).isPresent();
	}

	public boolean cursoValido(long id) {
		return cursoRepository.findById(id).isPresent();
	}
}

package com.fatec.grupo3.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.grupo3.controller.rest.docs.MatriculasRestControllerDocs;
import com.fatec.grupo3.model.service.MatriculasService;
import com.fatec.grupo3.utils.TokenUtils;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MatriculasRestController implements MatriculasRestControllerDocs {

	@Autowired
	private MatriculasService service;

	@Override
	@PostMapping("/matriculas/curso/{id}")
	public ResponseEntity<Optional<MatriculaDTO>> createMatricula(MatriculaDTO matricula, @PathVariable("id") Long idCurso,  HttpServletRequest request) {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.save(matricula, idCurso, token));
	}

	@Override
	@PostMapping("/matriculas/{id}/curso/{cursoId}/nota/{nota}")
	public ResponseEntity<Optional<MatriculaDTO>> updateMatricula(@PathVariable("id") Long id, @PathVariable("cursoId") Long idCurso, @PathVariable("nota") Double nota,
			HttpServletRequest request) throws Exception {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.atualiza(id, idCurso, nota, token));
	}

	@Override
	@GetMapping("/matriculas")
	public ResponseEntity<List<MatriculasDTO>> listMatricula(HttpServletRequest request) {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.consultaTodos(token));
	}

	@Override
	@GetMapping("/matriculas/usuario/curso/{cursoId}")
	public ResponseEntity<List<UsuarioDTO>> listMatriculaByCursoId(@PathVariable("cursoId") Long cursoId) {
		return ResponseEntity.ok(service.consultarUsuariosMatriculados(cursoId));
	}

	@Override
	@DeleteMapping("/matriculas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMatricula(@PathVariable("id") Long id, HttpServletRequest request) {
		String token = TokenUtils.wrapperToken(request);

		service.delete(id, token);
	}

	@Override
	@GetMapping("/matriculas/{id}")
	public ResponseEntity<Optional<MatriculasDTO>> consultaMatricula(@PathVariable("id") Long id, HttpServletRequest request) throws AreaProibidaException {
		String token = TokenUtils.wrapperToken(request);

		return ResponseEntity.ok(service.consultaPorId(id, token));
	}

	@Override
	@GetMapping("/matriculas/historico")
	public ResponseEntity<List<HistoricoDTO>> listHistorico(HttpServletRequest request) {
		String token = TokenUtils.wrapperToken(request);

		return ResponseEntity.ok(service.consultarHistorico(token));
	}
}

package com.fatec.grupo3.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.grupo3.controller.rest.docs.MatriculasRestControllerDocs;
import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.service.MatriculasService;
import com.fatec.grupo3.utils.TokenUtils;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MatriculasRestController implements MatriculasRestControllerDocs {

	@Autowired
	private MatriculasService service;

	@Override
	@PostMapping("/matriculas")
	public ResponseEntity<Optional<MatriculaDTO>> createMatricula(@Valid MatriculaDTO matricula, @PathVariable("id") Long idCurso,  HttpServletRequest request) {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.save(matricula, idCurso, token));
	}

	@Override
	@PostMapping("/matriculas/{id}")
	public ResponseEntity<Optional<MatriculaDTO>> updateMatricula(@PathVariable("id") Long id, @Valid MatriculaDTO matricula,
			HttpServletRequest request) throws Exception {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.atualiza(id, matricula, token));
	}

	@Override
	@GetMapping("/matriculas")
	public ResponseEntity<List<MatriculaDTO>> listMatricula(HttpServletRequest request) {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.consultaTodos());
	}
}

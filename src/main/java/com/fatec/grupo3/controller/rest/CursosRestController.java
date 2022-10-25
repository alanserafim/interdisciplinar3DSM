package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.CursosRestControllerDocs;
import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.dto.MatriculaDTO;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.service.CursosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CursosRestController implements CursosRestControllerDocs {

    @Autowired
    private CursosService service;

    @Override
    @PostMapping("/cursos")
    public ResponseEntity<Optional<CursoDTO>> createCurso(CursoDTO curso, HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);
        return ResponseEntity.ok(service.save(curso, token));
    }

	@Override
	@PostMapping("/cursos/{id}")
	public ResponseEntity<Optional<CursoDTO>> updateCurso(@PathVariable("id") Long id, @Valid CursoDTO matricula,
			HttpServletRequest request) throws Exception {
		String token = TokenUtils.wrapperToken(request);
		
		return ResponseEntity.ok(service.atualiza(id, matricula, token));
	}

	@Override
	@GetMapping("/cursos")
	public ResponseEntity<List<CursoDTO>> listCurso(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.consultaTodos());
	}
}

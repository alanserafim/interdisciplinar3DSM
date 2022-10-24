package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.CursosRestControllerDocs;
import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.service.CursosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"https://alanserafim.github.io/fatecflix-angular/", "http://localhost:4200/"})
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
}

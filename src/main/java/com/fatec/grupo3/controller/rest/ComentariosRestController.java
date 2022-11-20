package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.ComentariosRestControllerDocs;
import com.fatec.grupo3.model.dto.ComentarioDTO;
import com.fatec.grupo3.model.dto.ComentariosDTO;
import com.fatec.grupo3.model.service.ComentariosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ComentariosRestController implements ComentariosRestControllerDocs {

    @Autowired
    private ComentariosService service;


    @Override
    @PostMapping("/comentarios/aula/{aulaId}")
    public ResponseEntity<Optional<ComentarioDTO>> comentar(@RequestBody ComentarioDTO comentario, @PathVariable("aulaId") Long aulaId, HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.save(comentario, aulaId, token));
    }

    @Override
    @GetMapping("/comentarios/aula/{aulaId}")
    public ResponseEntity<List<ComentariosDTO>> listComentarios(@PathVariable("aulaId") Long aulaId) {
        return ResponseEntity.ok(service.consultaTodos(aulaId));
    }

    @Override
    @DeleteMapping("/comentarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComentario(@PathVariable("id") Long id) {
        service.delete(id);
    }
}

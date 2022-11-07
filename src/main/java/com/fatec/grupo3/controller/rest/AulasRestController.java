package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.AulasRestControllerDocs;
import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.AulaDTO;
import com.fatec.grupo3.model.dto.ListaAulaDTO;
import com.fatec.grupo3.model.service.AulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class AulasRestController implements AulasRestControllerDocs {

    @Autowired
    private AulasService service;

    @Override
    @PostMapping("/aulas/curso/{cursoId}")
    public ResponseEntity<Optional<AulaDTO>> createAula(@PathVariable("cursoId") Long cursoId,@Valid @RequestBody AulaDTO aulaDTO) throws Exception {
        return ResponseEntity.ok(service.save(cursoId, aulaDTO));
    }

    @Override
    @PostMapping("/aulas/{id}/curso/{cursoId}")
    public ResponseEntity<Optional<AulaDTO>> updateAula(@PathVariable("cursoId") Long cursoId, @PathVariable("id") Long id, AulaDTO aulaDTO) throws Exception {
        return ResponseEntity.ok(service.atualiza(cursoId, id, aulaDTO));
    }

    @Override
    @GetMapping("/aulas/curso/{cursoId}")
    public ResponseEntity<List<ListaAulaDTO>> listAula(@PathVariable("cursoId") Long cursoId) {
        return ResponseEntity.ok(service.consultaTodos(cursoId));
    }

    @Override
    @DeleteMapping("/aulas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAula(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/aulas/{id}")
    public ResponseEntity<Optional<AulaDTO>> consultaAula(@PathVariable("id") Long id) throws AreaProibidaException {
        return ResponseEntity.ok(service.consultarPorId(id));
    }
}

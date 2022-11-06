package com.fatec.grupo3.controller.rest;

import com.fatec.grupo3.controller.rest.docs.ExerciciosRestControllerDocs;
import com.fatec.grupo3.exception.AreaProibidaException;
import com.fatec.grupo3.model.dto.ExercicioDTO;
import com.fatec.grupo3.model.dto.ListaExercicioDTO;
import com.fatec.grupo3.model.service.ExerciciosService;
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
public class ExerciciosRestController implements ExerciciosRestControllerDocs {

    @Autowired
    private ExerciciosService service;

    @Override
    @PostMapping("/exercicios/curso/{cursoId}")
    public ResponseEntity<Optional<ExercicioDTO>> createExercicio(@PathVariable("cursoId") Long cursoId, @Valid @RequestBody ExercicioDTO exercicioDTO) throws Exception {
        return ResponseEntity.ok(service.save(cursoId, exercicioDTO));
    }

    @Override
    @PostMapping("/exercicios/{id}/curso/{cursoId}")
    public ResponseEntity<Optional<ExercicioDTO>> updateExercicio(@PathVariable("cursoId") Long cursoId, @PathVariable("id") Long id, @Valid @RequestBody ExercicioDTO exercicioDTO) throws Exception {
        return ResponseEntity.ok(service.atualiza(cursoId, id, exercicioDTO));
    }

    @Override
    @GetMapping("/exercicios/curso/{cursoId}")
    public ResponseEntity<List<ListaExercicioDTO>> listExercicio(@PathVariable("cursoId") Long cursoId) {
        return ResponseEntity.ok(service.consultaTodos(cursoId));
    }

    @Override
    @DeleteMapping("/exercicios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExercicio(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/exercicios/{id}")
    public ResponseEntity<Optional<ExercicioDTO>> consultaExercicio(@PathVariable("id") Long id) throws AreaProibidaException {
        return ResponseEntity.ok(service.consultarPorId(id));
    }
}

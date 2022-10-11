package com.fatec.grupo3.controller.front;

import com.fatec.grupo3.model.entities.Matricula;
import com.fatec.grupo3.model.service.MatriculasService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/grupo3")
public class MatriculaFrontController {
    Logger logger = LogManager.getLogger(MatriculaFrontController.class);

    @Autowired
    MatriculasService service;

    @GetMapping("/matriculas")
    public ModelAndView retornaFormDeConsultaTodasMatriculas(Matricula matricula) {
        ModelAndView mv = new ModelAndView("consultarMatricula");
        mv.addObject("matriculas", service.consultaTodos());

        return mv;
    }

    @GetMapping("/curso")
    public ModelAndView retornaFormDeCadastroDeMatricula(Matricula matricula) {
        ModelAndView mv = new ModelAndView("cadastrarMatricula");
        mv.addObject("curso", matricula);
        return mv;
    }


    @GetMapping("/cursos/{id}")
    public ModelAndView retornaFormParaEditarMatricula(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("atualizarCurso");

        Optional<Matricula> curso = service.consultaPorId(id);

        if(curso.isPresent()) {
            mv.addObject("curso", curso.get());
        } else {
            return new ModelAndView("paginaMenu");
        }

        return mv;
    }

    @GetMapping("/matriculas/id/{id}")
    public ModelAndView excluirNoFormDeConsultaMatriculas(@PathVariable("id") Long id) {
        service.delete(id);

        logger.info(">>>>>>>>> servico de exclusão chamado para o id => " + id);
        ModelAndView mv = new ModelAndView("consultarCurso");
        mv.addObject("cursos", service.consultaTodos());

        return mv;
    }

    @PostMapping("/cursos")
    public ModelAndView save(@Valid Matricula matricula, BindingResult result) {
        ModelAndView mv = new ModelAndView("consultarMatricula");

        if(result.hasErrors()) {
            mv.setViewName("cadastrarCurso");
        } else {
            if (service.save(matricula).isPresent()) {
                logger.info(">>>>>> controller chamou cadastrar e consultar todos");
                mv.addObject("cursos", service.consultaTodos());
            } else {
                logger.info(">>>>>> controller cadastrar com dados invalidos");
                mv.setViewName("cadastrarCurso");
                mv.addObject("message", "Dados invalidos");
            }
        }

        return mv;
    }

    @PostMapping("/cursos/id/{id}")
    public ModelAndView atualizaCurso(@PathVariable("id") Long id, @Valid Matricula matricula, BindingResult result) {
        ModelAndView mv = new ModelAndView("consultaMatricula");
        logger.info(">>>>>> servico para atualizacao de dados chamado para o id => " + id);

        if (result.hasErrors()) {
            logger.info(">>>>>> servico para atualizacao de dados com erro => " + result.getFieldError().toString());
            matricula.setMatriculaId(id);

            return new ModelAndView("atualizarMatricula");
        } else {
            service.atualiza(matricula);

            mv.addObject("cursos", service.consultaTodos());
        }

        return mv;
    }

}

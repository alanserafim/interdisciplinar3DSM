package com.fatec.grupo3.controller.front;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.service.CursosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/grupo3")
public class CursosFrontController {

    Logger logger = LogManager.getLogger(CursosFrontController.class);

    @Autowired
    CursosService service;

    @GetMapping("/cursos")
    public ModelAndView retornaFormDeConsultaTodosCursos(Curso curso) {
        ModelAndView mv = new ModelAndView("consultarCurso");
        mv.addObject("cursos", service.consultaTodos());

        return mv;
    }

    @GetMapping("/curso")
    public ModelAndView retornaFormDeCadastroDe(Curso curso) {
        ModelAndView mv = new ModelAndView("cadastrarCurso");
        mv.addObject("curso", curso);
        return mv;
    }


    @GetMapping("/cursos/{titulo}")
    public ModelAndView retornaFormParaEditarCliente(@PathVariable("titulo") String titulo) {
        ModelAndView mv = new ModelAndView("atualizarCurso");

        Optional<Curso> curso = service.consultaPorTitulo(titulo);

        if(curso.isPresent()) {
            mv.addObject("curso", curso.get());
        } else {
            return new ModelAndView("paginaMenu");
        }

        return mv;
    }

    @GetMapping("/cursos/id/{id}")
    public ModelAndView excluirNoFormDeConsultaCurso(@PathVariable("id") Long id) {
        service.delete(id);

        logger.info(">>>>>>>>> servico de exclusão chamado para o id => " + id);
        ModelAndView mv = new ModelAndView("consultarCurso");
        mv.addObject("cursos", service.consultaTodos());

        return mv;
    }

    @PostMapping("/cursos")
    public ModelAndView save(@Valid Curso curso, BindingResult result) {
        ModelAndView mv = new ModelAndView("consultarCurso");

        if(result.hasErrors()) {
            mv.setViewName("cadastrarCurso");
        } else {
            if (service.save(curso).isPresent()) {
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
    public ModelAndView atualizaCurso(@PathVariable("id") Long id, @Valid Curso curso, BindingResult result) {
        ModelAndView mv = new ModelAndView("consultaCurso");
        logger.info(">>>>>> servico para atualizacao de dados chamado para o id => " + id);

        if (result.hasErrors()) {
            logger.info(">>>>>> servico para atualizacao de dados com erro => " + result.getFieldError().toString());
            curso.setId(id);

            return new ModelAndView("atualizarCurso");
        } else {
            service.atualiza(curso);

            mv.addObject("cursos", service.consultaTodos());
        }

        return mv;
    }
}

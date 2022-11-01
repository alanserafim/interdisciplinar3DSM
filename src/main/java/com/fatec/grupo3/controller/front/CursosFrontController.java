package com.fatec.grupo3.controller.front;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fatec.grupo3.model.dto.CursoDTO;
import com.fatec.grupo3.model.entities.Curso;
import com.fatec.grupo3.model.service.CursosService;
import com.fatec.grupo3.utils.TokenUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/grupo3")
public class CursosFrontController {

    Logger logger = LogManager.getLogger(CursosFrontController.class);

    @Autowired
    CursosService service;

    @GetMapping("/cursos")
    public ModelAndView retornaFormDeConsultaTodosCursos(CursoDTO curso) {
        ModelAndView mv = new ModelAndView("consultarCurso");
        mv.addObject("cursos", service.consultaTodos());

        return mv;
    }

    @GetMapping("/curso")
    public ModelAndView retornaFormDeCadastroDeCurso(CursoDTO curso) {
        ModelAndView mv = new ModelAndView("cadastrarCurso");
        mv.addObject("curso", curso);
        return mv;
    }


    @GetMapping("/cursos/{id}")
    public ModelAndView retornaFormParaEditarCurso(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("atualizarCurso");

        /*Optional<CursoDTO> curso = service.consultarPorId(id);

        if(curso.isPresent()) {
            mv.addObject("curso", curso.get());
        } else {
            return new ModelAndView("paginaMenu");
        }*/

        return mv;
    }

    @GetMapping("/cursos/id/{id}")
    public ModelAndView excluirNoFormDeConsultaCurso(@PathVariable("id") Long id, HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);
        service.delete(id, token);

        logger.info(">>>>>>>>> servico de exclusão chamado para o id => " + id);
        ModelAndView mv = new ModelAndView("consultarCurso");
        mv.addObject("cursos", service.consultaTodos());

        return mv;
    }

    @PostMapping("/cursos")
    public ModelAndView save(@Valid CursoDTO curso, BindingResult result, HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);
        ModelAndView mv = new ModelAndView("consultarCurso");

        if(result.hasErrors()) {
            mv.setViewName("cadastrarCurso");
        } else {
            if (service.save(curso, token).isPresent()) {
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
    public ModelAndView atualizaCurso(@PathVariable("id") Long id, @Valid CursoDTO curso, BindingResult result,  HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);

        ModelAndView mv = new ModelAndView("consultaCurso");
        logger.info(">>>>>> servico para atualizacao de dados chamado para o id => " + id);

        if (result.hasErrors()) {
            logger.info(">>>>>> servico para atualizacao de dados com erro => " + result.getFieldError().toString());
            //curso.setCursoId(id);

            return new ModelAndView("atualizarCurso");
        } else {
            service.atualiza(id, curso, token);

            mv.addObject("cursos", service.consultaTodos());
        }

        return mv;
    }
}

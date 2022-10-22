package com.fatec.grupo3.controller.front;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.service.AulaService;
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
public class AulaFrontController {
	Logger logger = LogManager.getLogger(AulaFrontController.class);
	
	@Autowired
	AulaService service;
	
	@GetMapping("/aulas")
	public ModelAndView retornaFormConsultaTodasAulas(Aula aula) {
		ModelAndView mv = new ModelAndView("consultarAula");
		mv.addObject("aulas", service.consultaTodos());
		
		return mv;
	}
	
	@GetMapping("/aula")
	public ModelAndView retornaFomCadastroDeAula(Aula aula) {
		ModelAndView mv = new ModelAndView("cadastrarAula");
		mv.addObject("aula",aula);
		return mv;
	}
	
	@GetMapping("/aulas/{id}")
	public ModelAndView retornaFormParaEditarAula(@PathVariable("id") Long id) {
			ModelAndView mv = new ModelAndView("atualizarAula");
			
			Optional<Aula> aula = service.consultarPorId(id);
			
			if(aula.isPresent()) {
				mv.addObject("aula", aula.get());
			}else {
				return new ModelAndView("paginaMenu");
			}
			
			return mv;
	}
	
	@GetMapping("/aulas/id/{id}")
	public ModelAndView excluirNoFormDeConsultaAula(@PathVariable("id") Long id) {
		service.delete(id);
		
		logger.info(">>> servico de exclusão chamado para o id =>"+id);
		ModelAndView mv = new ModelAndView("consultarAula");
		mv.addObject("aulas", service.consultaTodos());
		
		return mv;
	}
	
	@PostMapping("/aulas")
	public ModelAndView save(@Valid Aula aula, BindingResult result) {
		ModelAndView mv = new ModelAndView("consultarAula");
		
		if(result.hasErrors()) {
			mv.setViewName("cadastrarAula");
		}else {
			if(service.save(aula).isPresent()) {
				logger.info(">>>> Chamou cadastrar e consultar");
				mv.addObject("aulas",service.consultaTodos());
			}else {
				logger.info(">>>> controller cadastrar com dados invalidos");
				mv.setViewName("cadastrarAula");
				mv.addObject("message","Dados invalidos");
			}
		}
		
		return mv;
	}

}

package com.fatec.grupo3.controller.front;

import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MenuFrontController {
    @Autowired
    private UsuariosService service;

    @GetMapping("/login")
    public ModelAndView autenticacao() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaLogin");

        return mv;
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("paginaMenu");
    }
}

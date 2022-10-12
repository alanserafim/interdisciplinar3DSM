package com.fatec.grupo3.controller.front;

import com.fatec.grupo3.model.entities.Login;
import com.fatec.grupo3.model.entities.Usuario;
import com.fatec.grupo3.model.service.UsuariosService;
import com.fatec.grupo3.security.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MenuFrontController {
    @Autowired
    private UsuariosService service;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaLogin");

        return mv;
    }

    @PostMapping("/")
    public String autenticacao(@RequestParam String username, @RequestParam String password, HttpServletResponse res) {
        Login login = new Login(username, password);

        Cookie cookie = new Cookie("jwt_token", service.logar(login).toString());

        cookie.setPath("/grupo3/");
        cookie.setMaxAge(Integer.MAX_VALUE);

        res.addCookie(cookie);

        return "redirect:/home";
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("paginaMenu");
    }
}

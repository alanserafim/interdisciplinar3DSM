package com.fatec.grupo3.controller.front;

import com.fatec.grupo3.model.dto.LoginDTO;
import com.fatec.grupo3.model.dto.UsuarioDTO;
import com.fatec.grupo3.model.service.UsuariosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuFrontController {
    @Autowired
    private UsuariosService service;

    Logger logger = LogManager.getLogger(ClientesFrontController.class);

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaLogin");

        return mv;
    }

    @PostMapping("/")
    public String autenticacao(@RequestParam String username, @RequestParam String password, HttpServletResponse res) {
        LoginDTO loginDTO = new LoginDTO(username, password);

        Cookie cookie = new Cookie("jwt_token", service.logar(loginDTO).toString());

        cookie.setPath("/grupo3/");
        cookie.setMaxAge(Integer.MAX_VALUE);

        res.addCookie(cookie);

        return "redirect:/home";
    }


    @GetMapping("/signUp")
    public ModelAndView signUp(UsuarioDTO usuario) {
        ModelAndView mv = new ModelAndView("cadastrarUsuario");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @PostMapping("/signUp")
    public ModelAndView save(@Valid UsuarioDTO usuario, BindingResult result) {
        ModelAndView mv = new ModelAndView("consultarUsuario");
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        usuario.setRoles(roles);
        if (result.hasErrors()) {
            mv.setViewName("cadastrarUsuario");
        } else {
            UsuarioDTO usuarioSaved = service.cadastrar(usuario);
            if (usuarioSaved != null) {
                mv.setViewName("paginaLogin");
            } else {
                logger.info(">>>>>> controller cadastrar com dados invalidos");
                mv.setViewName("cadastrarUsuario");
                mv.addObject("message", "Dados invalidos");
            }
        }
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("paginaMenu");
    }
}

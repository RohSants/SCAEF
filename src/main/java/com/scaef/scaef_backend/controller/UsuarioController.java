package com.scaef.scaef_backend.controller;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro(){
        ModelAndView cd = new ModelAndView();
        cd.addObject("usuario", new Usuario());
        cd.setViewName("cadastroUsuario");
        return cd;
    }
    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario usuario){
        ModelAndView cd = new ModelAndView();
        usuarioRepository.save(usuario);
        cd.setViewName("redirect:/home");
        return cd;
    }
    
}
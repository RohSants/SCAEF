package com.scaef.scaef_backend.controller;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/template")
    public ModelAndView template(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("template");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("cadastroUsuario");
        return mv;
    }
    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario usuario){
        ModelAndView mv = new ModelAndView();
        usuarioRepository.save(usuario);
        mv.setViewName("redirect:login");
        return mv;
    } 
    
    @PostMapping("/logar")
        public String logar(Model model, String email, String senha){
           usuarioRepository.Login(email, senha);
            if(usuarioRepository.Login(email, senha) !=  null){
                return "redirect:template";
            }

            model.addAttribute("erro", "email ou senha invalidos");
            return "login";
        }
    }
    

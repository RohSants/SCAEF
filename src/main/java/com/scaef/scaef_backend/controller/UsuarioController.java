package com.scaef.scaef_backend.controller;

import javax.validation.Valid;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
/*import org.springframework.web.bind.annotation.GetMapping;*/
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("/layout")
    public ModelAndView layout(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("fragments/layout");
        return mv;
    }

    @RequestMapping("/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("cadastroUsuario");
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:cadastroUsuario");
        return mv;
        }
        ModelAndView mv = new ModelAndView();
        usuarioRepository.save(usuario); 
        mv.setViewName("redirect:login");
        return mv;
    }
    
    @PostMapping("/logar")
        public String logar(Model model, String email, String senha){
           usuarioRepository.Login(email, senha);
            if(usuarioRepository.Login(email, senha) !=  null){
                return "redirect:home";
            }

            model.addAttribute("erro", "Email e/ou Senha Inválidos!");
            return "login";
        }
}
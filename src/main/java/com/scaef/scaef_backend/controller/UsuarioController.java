package com.scaef.scaef_backend.controller;


import java.util.Optional;

import javax.validation.Valid;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listagem")
    public String Usuario(Model model){
        model.addAttribute("listaUsuario", usuarioService.listar());
        return "index";
    }

    @GetMapping("/alterar/{id}")
    public String alterarUsuario(@PathVariable("id") int id, Model model){
        Optional<Usuario> usuarioOp = usuarioService.findById(id);
        if(usuarioOp.isEmpty()){
            throw new IllegalArgumentException("usuario inválido.");
        }
        model.addAttribute("usuario", usuarioOp.get());
        return "alterarUsuario";
    }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable("id") int id){
        Optional<Usuario> usuarioOp = usuarioService.findById(id);
        if(usuarioOp.isEmpty()){
            throw new IllegalArgumentException("usuario inválido.");
        }
        usuarioService.deletar(usuarioOp.get());
        return "redirect:/listagem";
    }

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

    @RequestMapping("/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("cadastroUsuario");
        return mv;
    }

    @PostMapping("cadastrarUsuario")
    public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.setViewName("redirect:/cadastro");
            return mv;
        }
        usuarioService.salvar(usuario); 
        mv.setViewName("redirect:salvarUsuario");
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView salvar(@ModelAttribute("usuario") Usuario usuario){
        ModelAndView mv = new ModelAndView();
        usuarioService.salvar(usuario); 
        mv.setViewName("listagem");
        return mv;
    }
    
    @PostMapping("/logar")
        public String logar(Model model, String email, String senha){
           usuarioService.logar(email, senha);
            if(usuarioService.logar(email, senha) !=  null){
                return "redirect:home";
            }
            model.addAttribute("erro", "Email e/ou Senha Inválidos!");
            return "login";
        }
}
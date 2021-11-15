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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public String logar(Model model, String email, String senha){
        usuarioService.logar(email, senha);
        if(usuarioService.logar(email, senha) !=  null){
            return "redirect:home";
        }
        model.addAttribute("erro", "Email e/ou Senha Inválidos!");
        return "login";
    }

    @PostMapping("salvarUsuario")
    public ModelAndView salvar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView(); 
        if(bindingResult.hasErrors()){
            mv.setViewName("redirect:usuario/cadastro");
            return mv;
        }
        //podemos ter uma outra forma de exibir erros
        usuarioService.salvar(usuario);
        mv.setViewName("redirect:usuario/listagem");
        return mv;
    }

    @RequestMapping("usuario/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastroUsuario");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @GetMapping("usuario/listagem")
    public ModelAndView Usuario(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listagemUsuario");
        model.addAttribute("listaUsuario", usuarioService.listar());
        return mv;    
    }

    @GetMapping("usuario/alterar/{id}")
        public ModelAndView buscar(@PathVariable int id, Model model){
            Optional<Usuario> usuario = usuarioService.findById(id);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("alterarUsuario");
            try {
                model.addAttribute("usuario", usuario.get());  
            } catch (Exception e) {
                mv.setViewName("redirect:usuario/listagem");
                return mv;
            }
            return mv;
        } 

    @GetMapping("usuario/excluir/{id}")
    public ModelAndView excluirUsuario(@PathVariable("id") int id){
        Optional<Usuario> usuarioOp = usuarioService.findById(id);
        ModelAndView mv = new ModelAndView();
        usuarioService.deletar(usuarioOp.get());
        mv.setViewName("redirect:/usuario/listagem");
        return mv;
    }
}
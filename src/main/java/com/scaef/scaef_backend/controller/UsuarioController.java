package com.scaef.scaef_backend.controller;

import java.util.Optional;
import javax.validation.Valid;

import com.scaef.scaef_backend.model.Usuario;
import com.scaef.scaef_backend.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String index(){
        return "redirect:login";
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /*@PostMapping("/logar")
    public String logar(Model model, String email, String senha, Usuario usuario){
        usuarioService.logar(email, senha);
        if(usuarioService.logar(email, senha) !=  null){
            return "redirect:home";
        } 
        model.addAttribute("erro", "Email e/ou Senha Inválidos!");
        return "login";    
    }*/

    @PostMapping("salvarUsuario")
    public ModelAndView salvar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult,RedirectAttributes ra){ 
        ModelAndView mv = new ModelAndView();
        BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
        String senhaCriptografada = criptografar.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuario.getSenha().equals(senhaCriptografada);
        if(bindingResult.hasErrors()){
            mv.setViewName("cadastroUsuario");
            mv.addObject("usuario", usuario);
            return mv;
        }
        usuarioService.salvar(usuario);
        ra.addFlashAttribute("message","Usuário cadastrado com sucesso!");
        mv.setViewName("redirect:usuario/cadastro");
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
        public ModelAndView buscar(@PathVariable Long id, Model model){
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
    public ModelAndView excluirUsuario(@PathVariable("id") Long id){
        Optional<Usuario> usuarioOp = usuarioService.findById(id);
        ModelAndView mv = new ModelAndView();
        usuarioService.deletar(usuarioOp.get());
        mv.setViewName("redirect:/usuario/listagem");
        return mv;
    }
}
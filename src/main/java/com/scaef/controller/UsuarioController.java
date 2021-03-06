package com.scaef.controller;

import java.security.Principal;
import java.util.Optional;
import javax.validation.Valid;

import com.scaef.model.Usuario;
import com.scaef.service.UsuarioService;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("public/index");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(Principal principal){
        ModelAndView mv = new ModelAndView();
        if (principal != null) {
            mv.setViewName("redirect:/home");
        }
        mv.setViewName("public/login");
        return mv;
    }

    
    @RequestMapping("/login-error")
    public ModelAndView loginerror(Model model, Principal principal){
        ModelAndView mv = new ModelAndView();

        model.addAttribute("erro", "Email e/ou Senha Inválidos!");
        mv.setViewName("error/loginError");

        if (principal != null) {
            mv.setViewName("redirect:/home");
        }

        return mv;
    }

    @RequestMapping("usuario/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastroUsuario");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView salvar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult,RedirectAttributes ra){ 
        ModelAndView mv = new ModelAndView();
        BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
        String senhaCriptografada = criptografar.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
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

    @GetMapping("usuario/listagem")
    public ModelAndView listar(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listagemUsuario");
        model.addAttribute("listaUsuario", usuarioService.listar());
        model.addAttribute("usuarioService", usuarioService);
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
                mv.setViewName("redirect:/usuario/listagem");
                return mv;
            }
            return mv;
        }

    @PostMapping("alterarUsuario")
    public ModelAndView alterar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, RedirectAttributes ra){
        ModelAndView mv = new ModelAndView();
        BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
        String senhaCriptografada = criptografar.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        if(bindingResult.hasErrors()){
            mv.setViewName("alterarUsuario");
            mv.addObject("usuario", usuario);
            return mv;
        }
        usuarioService.salvar(usuario);
        ra.addFlashAttribute("message","Usuário alterado com sucesso!");
        mv.setViewName("redirect:usuario/listagem");
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


    @RequestMapping(value = "/usuario/{id}", produces="application/json")
    public @ResponseBody String dadosUser(@PathVariable("id") Long id, Model model){
        Optional<Usuario> usuario = usuarioService.findById(id);
        String nomeUser = usuario.get().getNome();
        return nomeUser;
    }
}
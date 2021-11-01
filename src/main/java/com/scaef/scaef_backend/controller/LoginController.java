package com.scaef.scaef_backend.controller;





import com.scaef.scaef_backend.model.Login;
import com.scaef.scaef_backend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @Autowired
    private LoginRepository repo;

        @GetMapping("/login")
       
        public ModelAndView Login(Login login){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/login");
            mv.addObject("login", new Login());
            return mv;
        }  
        
        @PostMapping("logar")
        public String Logar(Model model, String senha, String email){
            Login login = this.repo.Login(email, senha);
            if (login != null){
                return "redirect:/";
            }
            model.addAttribute("erro", "email ou senha inválidos");
            return "login";
        }

       /* ModelAndView Logar(Login login){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/Login/LoginList");
        loginrepo.save(login);
        return mv;
    }*/



}
    


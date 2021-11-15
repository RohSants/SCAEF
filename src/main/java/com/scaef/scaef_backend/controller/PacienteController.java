package com.scaef.scaef_backend.controller;

import javax.validation.Valid;

import com.scaef.scaef_backend.model.Paciente;
import com.scaef.scaef_backend.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;
    
    @RequestMapping("paciente/cadastro")
    public ModelAndView cadastro(@Valid Paciente paciente){
        ModelAndView mv = new ModelAndView();
        mv.addObject("paciente", paciente);
        mv.setViewName("cadastroPaciente");
        return mv;
    }
    
    @PostMapping("salvarPaciente")
    public ModelAndView salvar(@ModelAttribute("paciente") Paciente paciente,  BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:paciente/listagem");
        if(bindingResult.hasErrors()){
            mv.setViewName("redirect:paciente/cadastro");
            return mv;
        }
        pacienteService.salvar(paciente);
        return mv;
    }

    @GetMapping("paciente/listagem")
    public String listar(Model model){
        model.addAttribute("listaPaciente", pacienteService.listar());
        return "listagemPaciente";
    }
}
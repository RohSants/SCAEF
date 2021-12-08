package com.scaef.scaef_backend.controller;

import java.util.Optional;
import javax.validation.Valid;

import com.scaef.scaef_backend.model.Paciente;
import com.scaef.scaef_backend.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;

    @RequestMapping("paciente/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("paciente", new Paciente());
        mv.setViewName("cadastroPaciente");
        return mv;
    }
    
    @PostMapping("salvarPaciente")
    public ModelAndView salvar(@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult bindingResult,RedirectAttributes ra){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.setViewName("cadastroPaciente");
            return mv;
        }
        pacienteService.salvar(paciente);
        ra.addFlashAttribute("message", "Paciente cadastrado com sucesso!");
        mv.setViewName("redirect:paciente/cadastro");
        return mv;
    }

    @GetMapping("paciente/listagem")
    public String listar(Model model){
        model.addAttribute("listaPaciente", pacienteService.listar());
        return "listagemPaciente";
    }

    @GetMapping("paciente/alterar/{id}")
    public ModelAndView buscar(@PathVariable long id, Model model){
        Optional<Paciente> paciente = pacienteService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alterarPaciente");
        try {
            model.addAttribute("paciente", paciente.get());  
        } catch (Exception e) {
            mv.setViewName("redirect:paciente/listagem");
            return mv;
        }
        return mv;
    } 

    @GetMapping("paciente/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") int id){
        Optional<Paciente> pacienteOp = pacienteService.findById(id);
        ModelAndView mv = new ModelAndView();
        pacienteService.deletar(pacienteOp.get());
        mv.setViewName("redirect:/paciente/listagem");
        return mv;
    }
}
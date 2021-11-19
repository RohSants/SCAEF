package com.scaef.scaef_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import java.util.Optional;

import javax.validation.Valid;

import com.scaef.scaef_backend.model.Medicamento;
import com.scaef.scaef_backend.service.MedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MedicamentoController {
    
    @Autowired
    private MedicamentoService medicamentoService;

    @RequestMapping("medicamento/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("medicamento", new Medicamento());
        mv.setViewName("cadastroMedicamento");
        return mv;
    }

    @PostMapping("salvarMedicamento")
    public ModelAndView salvar(@Valid @ModelAttribute("medicamento") Medicamento medicamento,BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.setViewName("redirect:medicamento/cadastro");
            mv.addObject("medicamento", medicamento);
            return mv;
        }
         mv.setViewName("redirect:medicamento/listagem");
         medicamentoService.salvar(medicamento);
         return mv;
    }    
    @GetMapping("medicamento/listagem")
    public String listar(Model model){
        model.addAttribute("listaMedicamento",medicamentoService.listar());
        return "listagemMedicamento";
    }

    @GetMapping("medicamento/alterar/{id}")
        public ModelAndView buscar(@PathVariable int id, Model model){
            Optional<Medicamento> medicamento = medicamentoService.findById(id);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("alterarMedicamento");
            try {
                model.addAttribute("medicamento", medicamento.get());  
            } catch (Exception e) {
                mv.setViewName("redirect:medicamento/listagem");
                return mv;
            }
            return mv;
        } 

    @GetMapping("medicamento/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") int id){
        Optional<Medicamento> medicamentoOp = medicamentoService.findById(id);
        ModelAndView mv = new ModelAndView();
        medicamentoService.deletar(medicamentoOp.get());
        mv.setViewName("redirect:/medicamento/listagem"); 
         return mv;
    }
}
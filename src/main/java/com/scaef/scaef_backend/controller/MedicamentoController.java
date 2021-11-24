package com.scaef.scaef_backend.controller;

import java.util.Optional;
import javax.validation.Valid;

import com.scaef.scaef_backend.model.Medicamento;
import com.scaef.scaef_backend.service.MedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MedicamentoController {
    
    @Autowired
    private MedicamentoService medicamentoService;

    @RequestMapping("medicamento/cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastroMedicamento");
        mv.addObject("medicamento", new Medicamento());
        return mv;
    }

    @PostMapping("salvarMedicamento")
    public ModelAndView salvar(@Valid @ModelAttribute("medicamento") Medicamento medicamento,BindingResult bindingResult){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.setViewName("cadastroMedicamento");
            mv.addObject("medicamento", medicamento);
            return mv;
        }
         medicamentoService.salvar(medicamento);
         mv.setViewName("redirect:medicamento/listagem");
         return mv;
    }    
    @GetMapping("medicamento/listagem")
    public ModelAndView Medicamento(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("listagemMedicamento");
        model.addAttribute("listaMedicamento",medicamentoService.listar());
        return mv;
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
package com.scaef.controller;

import java.util.Optional;
import javax.validation.Valid;

import com.scaef.model.Medicamento;
import com.scaef.service.MedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public ModelAndView salvar(@Valid @ModelAttribute("medicamento") Medicamento medicamento,BindingResult bindingResult,RedirectAttributes ra){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.addObject("medicamento", medicamento);
            mv.setViewName("cadastroMedicamento");
            return mv;
        }
        medicamentoService.salvar(medicamento);
        ra.addFlashAttribute("message", "Medicamento cadastrado com sucesso!");
        mv.setViewName("redirect:medicamento/cadastro");
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
        public ModelAndView buscar(@PathVariable Long id, Model model){
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

    @PostMapping("alterarMedicamento")
    public ModelAndView alterar(@Valid @ModelAttribute("medicamento") Medicamento medicamento,BindingResult bindingResult, RedirectAttributes ra){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.addObject("medicamento", medicamento);
            mv.setViewName("alterarMedicamento");
            return mv;
        }
        medicamentoService.salvar(medicamento);
        ra.addFlashAttribute("message","Medicamento alterado com sucesso!");
        mv.setViewName("redirect:medicamento/listagem");
        return mv;
    }

    @GetMapping("medicamento/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id){
        Optional<Medicamento> medicamentoOp = medicamentoService.findById(id);
        ModelAndView mv = new ModelAndView();
        medicamentoService.deletar(medicamentoOp.get());
        mv.setViewName("redirect:/medicamento/listagem"); 
        return mv;
    }

    @RequestMapping(value = "/medicamento/{id}", produces="application/json")
    public @ResponseBody String dadosMedicamento(@PathVariable("id") Long id, Model model){
        Optional<Medicamento> medicamento= medicamentoService.findById(id);
        String nomeMedicamento= medicamento.get().getNome();
        return nomeMedicamento;
    }
}
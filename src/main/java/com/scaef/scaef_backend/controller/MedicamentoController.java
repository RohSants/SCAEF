package com.scaef.scaef_backend.controller;


/Spring Framework/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResultUtils;

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
    
    @PostMapping("cadastrarMedicamento")
    public ModelAndView cadastrar(@Valid Medicamento medicamento, BindingResultUtils bindingResult){
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
            mv.setViewName("redirect:medicamento/cadastro");
            return mv;
        }
        mv.setViewName("redirect:salvarMedicamento");
        return mv;
    }

    @PostMapping("salvarMedicamento")
    public String salvar(@ModelAttribute("medicamento") Medicamento medicamento){
        medicamentoService.salvar(medicamento);
        return "redirect:medicamento/listagem";
    }
    @GetMapping("medicamento/listagem")
    public String Medicamento(Model model){
        model.addAttribute("listaMedicamento",medicamentoService.listar());
        return "listagemMedicamento";
    }

    @GetMapping("medicamento/alterar/{id}")
        public String buscar(@PathVariable int id, Model model){
            Optional<Medicamento> medicamento = medicamentoService.findById(id);
            try {
                model.addAttribute("medicamento", medicamento.get());  
            } catch (Exception e) {
                return "redirect:/medicamento/listagem";
            }
            return "alterarMedicamento";
        } 

    @GetMapping("medicamento/excluir/{id}")
    public String excluirMedicamento(@PathVariable("id") int id){
        Optional<Medicamento> medicamentoOp = medicamentoService.findById(id);
        medicamentoService.deletar(medicamentoOp.get());
        return "redirect:/medicamento/listagem";

    
}
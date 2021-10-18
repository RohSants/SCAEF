package com.scaef.scaef_backend.controller;

import javax.validation.Valid;

/*Classes SCAEF*/
import com.scaef.scaef_backend.dto.MedicamentoDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.exception.MedicamentoNotFoundException;
import com.scaef.scaef_backend.service.MedicamentoService;

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Medicamento")
public class MedicamentoController {
    
    private MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid MedicamentoDTO medicamentoDTO){ 
        return medicamentoService.create(medicamentoDTO);
    }

    @GetMapping("/{id}")
    public MedicamentoDTO findById(@PathVariable int id) throws MedicamentoNotFoundException{ 
        return medicamentoService.findById(id);
    }
}
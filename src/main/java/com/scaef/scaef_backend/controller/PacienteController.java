package com.scaef.scaef_backend.controller;

/*Classes SCAEF*/
import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.service.PacienteService;

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Paciente")
public class PacienteController {
    
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }
    
    @PostMapping
    public MessageResponseDTO create(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.create(pacienteDTO);
    }
}
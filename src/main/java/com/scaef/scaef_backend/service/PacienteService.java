package com.scaef.scaef_backend.service;

import com.scaef.scaef_backend.exception.PacienteNotFoundException;
import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.repository.PacienteRepository;
import com.scaef.scaef_backend.mapper.PacienteMapper;
import com.scaef.scaef_backend.model.Paciente;

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    private final PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public MessageResponseDTO create(PacienteDTO pacienteDTO){

        Paciente pacienteToSave = pacienteMapper.toModel(pacienteDTO);
        Paciente savedPaciente = pacienteRepository.save(pacienteToSave);
        
        return MessageResponseDTO.builder().message("Paciente " + savedPaciente.getNome() + " cadastrado com a ID = " + savedPaciente.getId()).build(); 
    }

    public PacienteDTO findById(long id) throws PacienteNotFoundException {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException(id));
        return pacienteMapper.toDTO(paciente);
    }
}
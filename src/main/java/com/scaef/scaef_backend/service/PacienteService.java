package com.scaef.scaef_backend.service;

/*Classes SCAEF*/
import com.scaef.scaef_backend.entity.Paciente;
import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.repository.PacienteRepository;
import com.scaef.scaef_backend.mapper.PacienteMapper;
/*import com.scaef.scaef_backend.exception.PacienteNotFoundException;*/

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
}
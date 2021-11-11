package com.scaef.scaef_backend.service;

import com.scaef.scaef_backend.exception.MedicamentoNotFoundException;

import com.scaef.scaef_backend.dto.MedicamentoDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.repository.MedicamentoRepository;
import com.scaef.scaef_backend.mapper.MedicamentoMapper;
import com.scaef.scaef_backend.model.Medicamento;

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    

    private MedicamentoRepository medicamentoRepository;

    private final MedicamentoMapper medicamentoMapper = MedicamentoMapper.INSTANCE;

    
    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }

    public MessageResponseDTO create(MedicamentoDTO medicamentoDTO){ 

        Medicamento medicamentoToSave = medicamentoMapper.toModel(medicamentoDTO);
        Medicamento savedMedicamento = medicamentoRepository.save(medicamentoToSave);
        
        return MessageResponseDTO.builder().message("Medicamento " + savedMedicamento.getNome() + " registrado no sistema com o código: " + savedMedicamento.getId()).build();
    }

    public MedicamentoDTO findById(int id) throws MedicamentoNotFoundException {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(() -> new MedicamentoNotFoundException(id));
        return medicamentoMapper.toDTO(medicamento);
    } 
}
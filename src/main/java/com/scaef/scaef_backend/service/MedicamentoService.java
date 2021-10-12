package com.scaef.scaef_backend.service;

/*Classes SCAEF*/
import com.scaef.scaef_backend.entity.Medicamento;
import com.scaef.scaef_backend.dto.MedicamentoDTO;
import com.scaef.scaef_backend.dto.MessageResponseDTO;
import com.scaef.scaef_backend.repository.MedicamentoRepository;
import com.scaef.scaef_backend.mapper.MedicamentoMapper;
/*import com.scaef.scaef_backend.exception.MedicamentoNotFoundException;*/

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public MedicamentoDTO findById(int id) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);
        return medicamentoMapper.toDTO(optionalMedicamento.get());
    } 
}
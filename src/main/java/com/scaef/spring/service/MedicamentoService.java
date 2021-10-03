package com.scaef.spring.service;

import com.scaef.spring.dto.MedicamentoDTO;
import com.scaef.spring.dto.MessageResponseDTO;
import com.scaef.spring.entity.Medicamento;
import com.scaef.spring.mapper.MedicamentoMapper;
import com.scaef.spring.repository.MedicamentoRepository;

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
            return MessageResponseDTO.builder()
            .message("Medicamento " + savedMedicamento.getNome() + " registrado no sistema com o código: " + savedMedicamento.getId())
            .build();
        }


}
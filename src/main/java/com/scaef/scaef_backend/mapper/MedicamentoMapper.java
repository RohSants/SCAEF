package com.scaef.scaef_backend.mapper;

import com.scaef.scaef_backend.dto.MedicamentoDTO;
import com.scaef.scaef_backend.model.Medicamento;

/*MapStruct*/
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoMapper {
    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);
    
    Medicamento toModel(MedicamentoDTO medicamentoDTO);

    MedicamentoDTO toDTO(Medicamento medicamento);
}
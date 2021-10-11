package com.scaef.scaef_backend.mapper;

/*Classes SCAEF*/
import com.scaef.scaef_backend.entity.Medicamento;
import com.scaef.scaef_backend.dto.MedicamentoDTO;

/*MapStruct*/
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoMapper {
    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);
    
    Medicamento toModel(MedicamentoDTO medicamentoDTO);

    static MedicamentoDTO toDTO(Medicamento medicamento) {
        return null;
    }
}
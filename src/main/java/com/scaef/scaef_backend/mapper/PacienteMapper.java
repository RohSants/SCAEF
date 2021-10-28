package com.scaef.scaef_backend.mapper;

import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.model.Paciente;

/*MapStruct*/
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    Paciente toModel(PacienteDTO pacienteDTO);

    PacienteDTO toDTO(Paciente paciente);
}
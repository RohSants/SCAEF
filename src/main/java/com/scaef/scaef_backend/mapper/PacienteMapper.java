package com.scaef.scaef_backend.mapper;

/*Classes SCAEF*/
import com.scaef.scaef_backend.entity.Paciente;
import com.scaef.scaef_backend.dto.PacienteDTO;

/*MapStruct*/
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    Paciente toModel(PacienteDTO pacienteDTO);

    PacienteDTO toDTO(Paciente paciente);
}
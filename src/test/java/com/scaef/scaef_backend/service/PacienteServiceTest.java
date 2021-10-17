package com.scaef.scaef_backend.service;

import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.entity.Paciente;
import com.scaef.scaef_backend.exception.PacienteNotFoundException;
import com.scaef.scaef_backend.repository.PacienteRepository;
import com.scaef.scaef_backend.utils.PacienteUtils;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {
    
    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    void WhenGivenExistingIdReturnThisPatient() throws PacienteNotFoundException{
      Paciente expectedFoundPaciente = PacienteUtils.createFakePaciente();

        Mockito.when(pacienteRepository.findById(expectedFoundPaciente.getId())).thenReturn(Optional.of(expectedFoundPaciente));

        PacienteDTO pacienteDTO = pacienteService.findById(expectedFoundPaciente.getId());

        Assertions.assertEquals(expectedFoundPaciente.getNome(), pacienteDTO.getNome());
        Assertions.assertEquals(expectedFoundPaciente.getCns(), pacienteDTO.getCns());
        Assertions.assertEquals(expectedFoundPaciente.getCpf(), pacienteDTO.getCpf());
        Assertions.assertEquals(expectedFoundPaciente.getRg(), pacienteDTO.getRg());
        Assertions.assertEquals(expectedFoundPaciente.getDNasc(), pacienteDTO.getDNasc());
        Assertions.assertEquals(expectedFoundPaciente.getEmail(), pacienteDTO.getEmail());
        Assertions.assertEquals(expectedFoundPaciente.getCida(), pacienteDTO.getCida());
        Assertions.assertEquals(expectedFoundPaciente.getEndr(), pacienteDTO.getEndr());
        Assertions.assertEquals(expectedFoundPaciente.getComp(), pacienteDTO.getComp());
        Assertions.assertEquals(expectedFoundPaciente.getCep(), pacienteDTO.getCep());
        Assertions.assertEquals(expectedFoundPaciente.getNum(), pacienteDTO.getNum());
        Assertions.assertEquals(expectedFoundPaciente.getCelular(), pacienteDTO.getCelular());
        Assertions.assertEquals(expectedFoundPaciente.getFone(), pacienteDTO.getFone());
    }

    @Test
    void whenGivenUnexistingIdThenNotFindThrowAnException(){
      var invalidId = 10;

      when(pacienteRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Paciente.class)));

      assertThrows(PacienteNotFoundException.class, () -> pacienteService.findById(invalidId));
    }
}
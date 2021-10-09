package com.scaef.spring.service;

/*import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.scaef.spring.dto.MedicamentoDTO;
import com.scaef.spring.entity.Medicamento;
import com.scaef.spring.repository.MedicamentoRepository;
import com.scaef.spring.utils.MedicamentoUtils;
import com.scaef.spring.exception.MedicamentoNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.var;

@ExtendWith(MockitoExtension.class)
public class MedicamentoServiceTest {
    
    @Mock
    private MedicamentoRepository medicamentoRepository;

    @InjectMocks
    private MedicamentoService medicamentoService;

    @Test
    void returnThisMedicine() throws MedicamentoNotFoundException{
        Medicamento expectedFoundMedicamento = MedicamentoUtils.createFakeMedicamento();

        Mockito.when(medicamentoRepository.findById(expectedFoundMedicamento.getId())).thenReturn(Optional.of(expectedFoundMedicamento));

      MedicamentoDTO medicamentoDTO = medicamentoService.findById(expectedFoundMedicamento.getId());

      Assertions.assertEquals(expectedFoundMedicamento.getNome(), medicamentoDTO.getNome());

      Assertions.assertEquals(expectedFoundMedicamento.getCid(), medicamentoDTO.getCid());

      Assertions.assertEquals(expectedFoundMedicamento.getCatReg(), medicamentoDTO.getCatReg());

      Assertions.assertEquals(expectedFoundMedicamento.getPcdt(), medicamentoDTO.getPcdt());

      Assertions.assertEquals(expectedFoundMedicamento.getDose(), medicamentoDTO.getDose());

      Assertions.assertEquals(expectedFoundMedicamento.getForma(), medicamentoDTO.getForma());

      Assertions.assertEquals(expectedFoundMedicamento.getVia(), medicamentoDTO.getVia());

      Assertions.assertEquals(expectedFoundMedicamento.getPriA(), medicamentoDTO.getPriA());

      Assertions.assertEquals(expectedFoundMedicamento.getClasseT(), medicamentoDTO.getClasseT());

    }

    @Test
    void whenGivenunexistindId(){
      var invalidId = 10;

      when(medicamentoRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Medicamento.class)));

      assertThrows(MedicamentoNotFoundException.class, () -> medicamentoService.findById(invalidId));
    }
}*/
package com.scaef.scaef_backend.service;

import java.util.Optional;

import javax.validation.Valid;


import com.scaef.scaef_backend.model.Medicamento;
import com.scaef.scaef_backend.repository.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MedicamentoService {


    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public Object listar() {
        return medicamentoRepository.findAll();
    }

    public void salvar(@Valid Medicamento medicamento) {
        medicamentoRepository.save(medicamento);
    }

    public Optional<Medicamento> findById(Long id) {
        return medicamentoRepository.findById(id);
    }

    public void deletar(Medicamento medicamento) {
        medicamentoRepository.delete(medicamento);
    }
  
}
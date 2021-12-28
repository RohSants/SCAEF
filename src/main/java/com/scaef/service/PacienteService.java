package com.scaef.service;

import java.util.Optional;

import javax.validation.Valid;

import com.scaef.model.Paciente;
import com.scaef.repository.PacienteRepository;

/*Spring Framework*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void salvar(@Valid Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public Object listar() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(long id) {
        return pacienteRepository.findById(id);
    }

    public void deletar(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }
}
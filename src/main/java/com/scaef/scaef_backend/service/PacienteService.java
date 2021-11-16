package com.scaef.scaef_backend.service;

import java.util.Optional;

import javax.validation.Valid;

import com.scaef.scaef_backend.repository.PacienteRepository;
import com.scaef.scaef_backend.model.Paciente;

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
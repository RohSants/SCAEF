package com.scaef.repository;

import com.scaef.model.Paciente;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    
}
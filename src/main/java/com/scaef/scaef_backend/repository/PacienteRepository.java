package com.scaef.scaef_backend.repository;

/*Classe SCAEF*/
import com.scaef.scaef_backend.model.Paciente;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    
}
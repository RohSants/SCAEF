package com.scaef.scaef_backend.repository;

/*Classe SCAEF*/
import com.scaef.scaef_backend.entity.Paciente;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Integer> {
    
}
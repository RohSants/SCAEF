package com.scaef.scaef_backend.repository;

 import com.scaef.scaef_backend.model.Medicamento;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository <Medicamento, Integer> {
    
}
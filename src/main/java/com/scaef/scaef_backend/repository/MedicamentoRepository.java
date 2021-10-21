package com.scaef.scaef_backend.repository;


/*Classe SCAEF*/
import com.scaef.scaef_backend.entity.Medicamento;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository <Medicamento, Integer> {
    
}
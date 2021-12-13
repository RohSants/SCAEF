package com.scaef.repository;

 import com.scaef.model.Medicamento;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicamentoRepository extends JpaRepository <Medicamento, Long> {
    @Query(value = "select id from Medicamento where id =:id", nativeQuery = true)
    boolean exist(Long id);
    
}
package com.scaef.scaef_backend.repository;

/*Classe SCAEF*/
import com.scaef.scaef_backend.model.Usuario;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
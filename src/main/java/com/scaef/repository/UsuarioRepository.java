package com.scaef.repository;

import com.scaef.model.Usuario;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario findByNome(String nome);
}

        
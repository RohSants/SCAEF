package com.scaef.scaef_backend.repository;

import com.scaef.scaef_backend.model.Usuario;

/*Extends JPARepository*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select id from Usuario where id =:id", nativeQuery = true)
    public boolean exist(Long id);

    @Query(value= " select * from Usuario where email= :email and senha = :senha", nativeQuery = true)
    public Usuario Login(String email, String senha);

    public Usuario findByNome(String nome);
    

}

        
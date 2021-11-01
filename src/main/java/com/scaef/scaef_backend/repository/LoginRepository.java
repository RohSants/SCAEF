package com.scaef.scaef_backend.repository;

import com.scaef.scaef_backend.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface LoginRepository extends JpaRepository<Login, Long>{

    @Query(value="select * from login where email: email and senha: senha",nativeQuery = true)
    public Login Login(String email, String senha);
     
}
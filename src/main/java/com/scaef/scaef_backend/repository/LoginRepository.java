package com.scaef.scaef_backend.repository;

import com.scaef.scaef_backend.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;




public interface LoginRepository extends JpaRepository<Login, Long>{
    
}
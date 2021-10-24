package com.scaef.scaef_backend.repository;

import com.scaef.scaef_backend.entity.Login;

import org.springframework.data.jpa.repository.JpaRepository;




public interface LoginRepository extends JpaRepository<Login, Long>{
    
}
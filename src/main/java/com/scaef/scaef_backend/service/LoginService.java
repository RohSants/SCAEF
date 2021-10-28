package com.scaef.scaef_backend.service;

import java.util.List;

import com.scaef.scaef_backend.model.Login;

public interface LoginService {
    
    List<Login> findAll();
    Login FindById(long Id);
    Login save(Login login);

}
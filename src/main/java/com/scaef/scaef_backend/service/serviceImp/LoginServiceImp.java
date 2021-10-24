package com.scaef.scaef_backend.service.serviceImp;

import java.util.List;

import com.scaef.scaef_backend.entity.Login;
import com.scaef.scaef_backend.repository.LoginRepository;
import com.scaef.scaef_backend.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login FindById(long Id) {
        return loginRepository.findById(Id).get();
    }

    @Override
    public Login save(Login login) {
      
        return loginRepository.save(login);
    }
    
}
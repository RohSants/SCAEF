package com.scaef.scaef_backend.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.scaef.scaef_backend.entity.Login;
import com.scaef.scaef_backend.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUtils {
    @Autowired
    LoginRepository loginRepository;

   // @PostConstruct
    public void saveLogin(){

        List<Login> loginList = new ArrayList<>();
        Login login1 = new Login();
        login1.setEmail("Bruno@Alexandre");
        login1.setSenha("nemsei1234423");
        
        loginList.add(login1);
       

        for(Login login: loginList){
            Login loginSaved = loginRepository.save(login);
            System.out.println(loginSaved.getCod());
        }
    }
}
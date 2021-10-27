package com.scaef.scaef_backend.controller;

import java.util.List;

import com.scaef.scaef_backend.entity.Login;
import com.scaef.scaef_backend.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin(){

        ModelAndView mv  = new ModelAndView("login");
        List<Login> login = loginService.findAll();
        mv.addObject("login", login);
        return mv;

    }
    
}
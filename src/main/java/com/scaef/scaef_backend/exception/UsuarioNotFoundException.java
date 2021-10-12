package com.scaef.scaef_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends Exception {

    public UsuarioNotFoundException(int id){
        super(String.format("Usuário não encontrado",id));
    }
}
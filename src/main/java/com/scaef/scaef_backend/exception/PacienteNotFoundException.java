package com.scaef.scaef_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacienteNotFoundException extends Exception {

    public PacienteNotFoundException(long id){
        super(String.format("Paciente com Id não encontrado", id));
    }
}
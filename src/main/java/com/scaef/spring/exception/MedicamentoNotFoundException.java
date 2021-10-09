package com.scaef.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MedicamentoNotFoundException extends Exception {

    public MedicamentoNotFoundException(int id){
        super(String.format("Medicamento não encontrado:(", id));

    }

}
    
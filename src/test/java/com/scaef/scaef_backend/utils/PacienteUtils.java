package com.scaef.scaef_backend.utils;

import com.scaef.scaef_backend.dto.PacienteDTO;
import com.scaef.scaef_backend.entity.Paciente;

import com.github.javafaker.Faker;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PacienteUtils {
    
    private static final Faker faker = Faker.instance();

    public static PacienteDTO createFakePacienteDTO(){
        return PacienteDTO.builder()
            .id(faker.number().randomNumber())
            .nome(faker.name().firstName())
            .cns(faker.numerify("###############"))
            .cpf(faker.numerify("###########"))
            /*.rg(faker.numerify("########"))*/
            .dataNasc("a")
            .cida(faker.name().firstName())
            .endr(faker.name().firstName()) 
            .comp(faker.name().firstName())
            .cep(faker.number().randomNumber())
            .num(faker.number().randomDigit())
            .celular(faker.numerify("(##) ####-####"))
            .fone(faker.numerify("(##) ####-####"))
            .email(faker.name().firstName())
            .build();
    }

    public static Paciente createFakePaciente(){
        return Paciente.builder()
            .id(faker.number().randomNumber())
            .nome(faker.name().firstName())
            .cns(faker.numerify("###############"))
            .cpf(faker.numerify("###########"))
            /*.rg(faker.numerify("##########"))*/
            .dataNasc("a")
            .cida(faker.name().firstName())
            .endr(faker.name().firstName()) 
            .comp(faker.name().firstName())
            .cep(faker.number().randomNumber())
            .num(faker.number().randomDigit())
            .celular(faker.numerify("(##) ####-####"))
            .fone(faker.numerify("(##) ####-####"))
            .email(faker.name().firstName())
            .build();
    }

    public static Paciente createFakePacienteFrom(PacienteDTO pacienteDTO) {
        return Paciente.builder()
        .id(pacienteDTO.getId())
        .nome(pacienteDTO.getNome())
        .cns(pacienteDTO.getCns())
        .cpf(pacienteDTO.getCpf())
        /*.rg(pacienteDTO.getRg())*/
        .dataNasc(pacienteDTO.getDataNasc())
        .cida(pacienteDTO.getCida())
        .endr(pacienteDTO.getEndr()) 
        .comp(pacienteDTO.getComp())
        .cep(pacienteDTO.getCep())
        .num(pacienteDTO.getNum())
        .celular(pacienteDTO.getCelular())
        .fone(pacienteDTO.getFone())
        .email(pacienteDTO.getEmail())
        .build();
    }


    public static String asJsonString(PacienteDTO pacienteDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(pacienteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
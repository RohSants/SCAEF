package com.scaef.scaef_backend.utils;

import com.scaef.scaef_backend.dto.UsuarioDTO;
import com.scaef.scaef_backend.model.Usuario;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;

public class UsuarioUtils {
    
    private static final Faker faker = Faker.instance();

    public static UsuarioDTO createFakeUsuarioDTO(){
        return UsuarioDTO.builder()
                .id(faker.number().numberBetween(0, 100))
                .nome(faker.name().fullName())
                .cpf(faker.numerify("###########"))
                .rg((faker.numerify("#########")))
                .email(faker.name().firstName())
                .celular(faker.number().randomDigit())
                .fone(faker.number().randomDigit())
                .funcao(faker.name().firstName())
                .crf(faker.number().randomDigit())
                .build();
    }

    public static Usuario createFakeUsuario(){
        return Usuario.builder()
                .id(faker.number().numberBetween(0, 100))
                .nome(faker.name().fullName())
                .cpf(faker.numerify("###########"))
                .rg((faker.numerify("#########")))
                .email(faker.name().firstName())
                .celular(faker.number().randomDigit())
                .fone(faker.number().randomDigit())
                .funcao(faker.name().firstName())
                .crf(faker.number().randomDigit())
                .build();
    }
    
    public static Usuario createFakeUsuarioFrom(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .id(usuarioDTO.getId())
                .nome(usuarioDTO.getNome())
                .cpf(usuarioDTO.getCpf())
                .rg(usuarioDTO.getRg())
                .email(usuarioDTO.getEmail())
                .celular(usuarioDTO.getCelular())
                .fone(usuarioDTO.getFone())
                .funcao(usuarioDTO.getFuncao())
                .crf(usuarioDTO.getCrf())
                .build();
    }

    public static String asJsonString(UsuarioDTO usuarioDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(usuarioDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
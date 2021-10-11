package com.scaef.scaef_backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/*Projeto Lombok*/
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private int id;

    @NotBlank
    @Size(max = 95)
    private String nome;

    @NotBlank
    @Size(max = 15)
    private String cns;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 10)
    private String rg;
    
    @NotNull
    private Date dNasc;
    
    @NotBlank
    @Size(max = 95)
    private String email;
    
    @NotBlank
    @Size(max = 26)
    private String cida;
    
    @NotBlank
    @Size(max = 80)
    private String endr;
    
    @NotBlank
    @Size(max = 50)
    private String comp;
    
    @NotNull
    private int cep;
    
    @NotNull
    private int num;
    
    @NotNull
    private int celular;
    
    @NotNull
    private int fone;
}
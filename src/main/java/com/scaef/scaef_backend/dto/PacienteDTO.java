package com.scaef.scaef_backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

   /*@NotBlank
   @Size(max = 15)
   private String cns;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 10)
    private String rg;
    
    @NotBlank
    @Size(max = 10)
    private String dNasc;
    
    @Size(max = 95)
    private String email;
    
    @NotBlank
    @Size(max = 26)
    private String cida;
    
    @NotBlank
    @Size(max = 80)
    private String endr;
    
    @Size(max = 50)
    private String comp;
    
    @NotNull
    private long cep;
    
    @NotNull
    private int num;
    
    @NotNull
    private long celular;
    
    @NotNull
    private long fone;*/
}
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

    private long id;

    @NotBlank(message = "Nome do Paciente é obrigatório")
    @Size(max = 95)
    private String nome;

   @NotBlank(message = "CNS do Paciente é obrigatório")
   @Size(max = 15)
   private String cns;

    @NotBlank(message = "CPF do Paciente é obrigatório")
    @Size(max = 11)
    private String cpf;

    @NotBlank(message = "RG do Paciente é obrigatório")
    @Size(max = 10)
    private String rg;

    @NotBlank(message = "Data de Nascimento do Paciente é obrigatório")
    @Size(max = 10)
    private String dataNasc;

    @NotNull(message = "CEP do Paciente é obrigatório")
    private long cep;

    @NotBlank(message = "Cidade do Paciente é obrigatório")
    @Size(max = 26)
    private String cida;
    
    @NotBlank(message = "Bairro do Paciente é obrigatório")
    @Size(max = 95)
    private String bai;

    @NotBlank(message = "Endereço do Paciente é obrigatório")
    @Size(max = 80)
    private String endr;
    
    @Size(max = 50)
    private String comp;
    
    @NotNull(message = "Número de Residência do Paciente é obrigatório")
    private int num;
    
    @NotBlank(message = "Número de Celular do Paciente é obrigatório")
    @Size(max = 15)
    private String celular;
    
    @Size(max = 15)
    private String fone;
    
    @Size(max = 95)
    private String email;
}
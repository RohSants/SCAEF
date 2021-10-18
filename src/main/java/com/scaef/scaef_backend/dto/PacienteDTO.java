package com.scaef.scaef_backend.dto;

import javax.validation.constraints.NotBlank;
/*import javax.validation.constraints.NotNull;*/
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

   @NotBlank
   @Size(max = 15)
   private String cns;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    private String datanasc;
}
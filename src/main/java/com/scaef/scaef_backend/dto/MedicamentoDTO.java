package com.scaef.scaef_backend.dto;

import javax.validation.Valid;
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
public class MedicamentoDTO {

    private int id;

    @NotBlank
    @Size(max = 95)
    private String nome;

    @NotBlank
    @Size(max = 90)
    private String catReg;

    @NotBlank
    @Size(max = 50)
    private String pcdt;

    @NotBlank
    @Size(max = 15)
    private String dose;

    @NotNull
    @Size(max = 25)
    private String forma;

    @NotBlank
    @Size(max = 11)
    private String via;

    @NotBlank
    @Size(max = 50)
    private String priA;

    @NotBlank
    @Size(max = 50)
    private String classeT;

    @Valid
    private CidDTO cid;
}
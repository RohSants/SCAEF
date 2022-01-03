package com.scaef.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.scaef.enums.EnumFuncao;

import org.hibernate.validator.constraints.br.CPF;

/*Projeto Lombok*/
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity 
@Table(name = "usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private long id;

    @Column(name = "Nome", nullable = false)
    @Size(max = 100)
    @NotBlank(message = "o campo  Nome não pode ser vazio")
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    @CPF
    @Size(max = 14)
    @NotBlank(message = "o campo CPF não pode ser vazio")
    private String cpf;

    @Column(name = "RG", nullable = false, unique = true)
    @Size(min = 12, message = "o campo RG deve conter 9 dígitos")
    @NotBlank(message = "o campo RG não pode ser vazio")
    private String rg;
    
    @Column(name = "Email", nullable = true, unique = true)
    @NotBlank(message = "o campo Email não pode ser vazio")
    @Size(max = 100)
    @Email
    private String email;

    @Column(name = "Celular", nullable = false)
    @Size(min = 11, message ="o campo Celular deve conter 11 dígitos")
    @NotBlank(message = "o campo Celular não pode ser vazio")
    private String celular;

    @Column(name = "Fone_Fixo", nullable = true, unique = false)
    @Size(max = 15)
    private String fone;

    @Column(name = "Função", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Escolha uma das seguinte opções!")
    private EnumFuncao funcao;

    @Column(name = "CRF", nullable = true, unique = false)
    private String crf;

    @Column(name = "Senha", nullable = false)
    @Size(min = 9, max = 100, message = "a senha deve estar entre 9 e 20 caracteres.")
    @NotBlank(message = "o campo Senha não pode ser vazio!")
    private String senha;  
}
package com.scaef.scaef_backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private int id;

    @Column(name = "Nome", nullable = false)
    @NotBlank(message = "o campo não pode ser vazio")
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    @CPF
    @NotBlank(message = "o campo não pode ser vazio")
    private String cpf;

    @Column(name = "RG", nullable = false, unique = true)
    @NotNull(message = "o campo não pode ser nulo")
    @NotBlank(message = "o campo não pode ser vazio")
    private String rg;
    
    @Column(name = "Email", nullable = true, unique = true)
    @NotBlank(message = "o campo não pode ser vazio")
    @Email
    private String email;

    @Column(name = "Celular", nullable = true)
    private int celular;

    @Column(name = "Fone_Fixo", nullable = false)
    private int fone;

    @Column(name = "Função", nullable = false)
    private String funcao;

    @Column(name = "CRF", nullable = false, unique = true)
    private int crf;

    @Column(name = "Senha", nullable = false, unique = true)
    @Min(value = 9, message = "a senha deve conter mais de 9 caracteres.")
    @NotBlank(message = "o campo não pode ser vazio!")
    private String senha;
}
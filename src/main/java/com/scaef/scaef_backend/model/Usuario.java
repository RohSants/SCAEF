package com.scaef.scaef_backend.model;

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
import javax.validation.constraints.Size;
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
    @Size(max = 100)
    @NotBlank(message = "o campo não pode ser vazio")
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    @CPF
    @Size(max = 14)
    @NotBlank(message = "o campo não pode ser vazio")
    private String cpf;

    @Column(name = "RG", nullable = false, unique = true)
    @Size(max = 10)
    @NotBlank(message = "o campo não pode ser vazio")
    private String rg;
    
    @Column(name = "Email", nullable = true, unique = true)
    @NotBlank(message = "o campo não pode ser vazio")
    @Size(max = 100)
    @Email
    private String email;

    @Column(name = "Celular", nullable = false)
    @Size(max = 15)
    @NotBlank(message = "o campo não pode ser vazio")
    private String celular;

    @Column(name = "Fone_Fixo", nullable = true)
    @Size(max = 15)
    private String fone;

    @Column(name = "Função", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumFuncao funcao;

    @Column(name = "CRF", nullable = true, unique = true)
    private int crf;

    @Column(name = "Senha", nullable = false, unique = true)
    @Size(min = 9, max = 20, message = "a senha deve estar entre 9 e 20 caracteres.")
    @NotBlank(message = "o campo não pode ser vazio!")
    private String senha;
}
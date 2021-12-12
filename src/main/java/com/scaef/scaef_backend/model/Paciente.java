package com.scaef.scaef_backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

/*Projeto Lombok*/
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "paciente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Paciente")
    private long id;

    @Column(name = "Nome", nullable = false)
    @NotBlank(message = "Nome do Paciente é obrigatório")
    @Size(max = 95)
    private String nome;

    @Column(name = "Nome da Mãe", nullable = false)
    @NotBlank(message = "Nome da Mãe do Paciente é obrigatório")
    @Size(max = 95)
    private String nomeM;

    @Column(name = "Nome Social", nullable = true)
    @Size(max = 95)
    private String nomeS;
    
    @Column(name = "Nome Preferencial", nullable = true)
    @Size(max = 11)
    private String idNome;

    @Column(name = "Sexo", nullable = false)
    @Size(max = 9)
    @NotBlank(message = "Sexo do Paciente é obrigatório")
    private String sexo;

    @Column(name = "CNS", nullable = false, unique = true)
    @NotBlank(message = "CNS do Paciente é obrigatório")
    @Size(max = 15)
    private String cns;

    @Column(name = "CPF", nullable = false, unique = true)
    @CPF
    @NotBlank(message = "CPF do Paciente é obrigatório")
    private String cpf;

    @Column(name = "RG", nullable = false, unique = true)
    @NotBlank(message = "RG do Paciente é obrigatório")
    @Size(max = 10)
    private String rg;

    @Column(name = "Nascimento", nullable = false)
    @NotBlank(message = "Data de Nascimento do Paciente é obrigatório")
    @Size(max = 10)
    private String dataNasc;

    @Column(name = "CEP", nullable = false)
    @NotNull(message = "CEP do Paciente é obrigatório")
    private String cep;

    @NotBlank(message = "Cidade do Paciente é obrigatório")
    @Size(max = 26)
    @Column(name = "Cidade", nullable = false)
    private String cida;

    @Column(name = "Bairro", nullable = false)
    @NotBlank(message = "Bairro do Paciente é obrigatório")
    @Size(max = 95)
    private String bai;
    
    @Column(name = "Endereço", nullable = false)
    @NotBlank(message = "Endereço do Paciente é obrigatório")
    @Size(max = 80)
    private String endr;
    
    @Column(name = "Complemento", nullable = true)
    @Size(max = 80, message="Complemento tem um limite de 80 caracteres")
    private String comp;    
    
    @Column(name = "Número_R", nullable = false)
    @NotNull(message = "Número de Residência do Paciente é obrigatório")
    private int num;
    
    @Column(name = "Celular", nullable = false)
    @NotBlank(message = "Número de Celular do Paciente é obrigatório")
    @Size(max = 15)
    private String celular;
    
    @Column(name = "Fone_Fixo", nullable = true)
    @Size(max = 15)
    private String fone;
    
    @Column(name = "Email", nullable = true)
    @Email
    @Size(max = 95)
    private String email;
}
package com.scaef.scaef_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Projeto Lombok*/
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Paciente")
    private int id;

    @Column(name = "Nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "CNS", nullable = false, unique = true)
    private String cns;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @Column(name = "RG", nullable = false, unique = true)
    private String rg;
    
    @Column(name = "Nascimento", nullable = false)
    private String dNasc;
    
    /*@Column(name = "Email", nullable = true)
    private String email;
    
    /*@Column(name = "Cidade", nullable = false)
    private String cida;
    
    @Column(name = "Endereço", nullable = false)
    private String endr;
    
    @Column(name = "Complemento", nullable = true)
    private String comp;
    
    @Column(name = "CEP", nullable = false)
    private long cep;
    
    @Column(name = "Número_R", nullable = false)
    private int num;
    
    @Column(name = "Celular", nullable = false)
    private long celular;
    
    @Column(name = "Fone_Fixo", nullable = false)
    private long fone;*/
}
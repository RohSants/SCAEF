package com.scaef.scaef_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import java.sql.Date;*/
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
    
   /*@Column(name = "Nascimento", nullable = false)
    private Date dNasc;*/
    
    @Column(name = "Email", nullable = false)
    private String email;
    
    @Column(name = "Município", nullable = false)
    private String mun;
    
    @Column(name = "Endereço", nullable = false)
    private String endr;
    
    @Column(name = "Complemento", nullable = false)
    private String comp;
    
    @Column(name = "CEP", nullable = false)
    private int cep;
    
    @Column(name = "Número_R", nullable = false)
    private int num;
    
    @Column(name = "Celular", nullable = false)
    private int celular;
    
    @Column(name = "Fone Fixo", nullable = false)
    private int fone;
}
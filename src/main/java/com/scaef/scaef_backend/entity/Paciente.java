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

    @Column(name = "Nascimento", nullable = false)
    private String datanasc;
}
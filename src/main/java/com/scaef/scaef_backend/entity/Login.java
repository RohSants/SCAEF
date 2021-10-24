package com.scaef.scaef_backend.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Login{

    

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long cod;

    @NotBlank
    private String senha;

    @NotBlank
    private String email;

    /**
     * @return long return the cod
     */
    public long getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(long cod) {
        this.cod = cod;
    }

    /**
     * @return String return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
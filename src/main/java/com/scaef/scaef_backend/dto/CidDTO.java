package com.scaef.scaef_backend.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidDTO {
    
    private String cod;
}
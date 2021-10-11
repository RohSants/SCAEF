package com.scaef.scaef_backend.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class MessageResponseDTO {
    private String message;
}
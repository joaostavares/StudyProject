package com.stagproj.BankingAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaDto {
    private long idConta;
    public ContaDto(Long idConta) {
        this.idConta = idConta;
    }
}

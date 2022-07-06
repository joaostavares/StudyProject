package com.stagproj.BankingAPI.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransacaoRequest {

    private double valor;

    private String dataTransacao;

    private Long contaId;
}

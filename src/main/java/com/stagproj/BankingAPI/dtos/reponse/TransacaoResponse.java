package com.stagproj.BankingAPI.dtos.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransacaoResponse {

    private double valor;

    private String dataTransacao;

    private Long idConta;
}

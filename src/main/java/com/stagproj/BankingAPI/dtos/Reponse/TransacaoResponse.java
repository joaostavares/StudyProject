package com.stagproj.BankingAPI.dtos.Reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransacaoResponse {

    private double valor;

    private String dataTransacao;

    public long idConta;
}

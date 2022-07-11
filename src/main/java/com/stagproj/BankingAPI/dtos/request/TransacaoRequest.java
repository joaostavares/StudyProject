package com.stagproj.BankingAPI.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransacaoRequest {

    private double valor;

    private String dataTransacao;

    private Long idConta;

    @JsonIgnore
    private Long id;
}

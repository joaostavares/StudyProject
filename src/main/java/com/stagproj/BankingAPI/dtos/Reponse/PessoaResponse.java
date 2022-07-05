package com.stagproj.BankingAPI.dtos.Reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponse {

    private String nome;

    private String cpf;

    private String dataNascimento;

    private long idConta;
}

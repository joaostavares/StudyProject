package com.stagproj.BankingAPI.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRequest {

    private String nome;

    private String cpf;

    private String dataNascimento;

    private long idConta;
}

package com.stagproj.BankingAPI.dtos.Reponse;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PessoaResponse {

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private long idConta;
}

package com.stagproj.BankingAPI.dtos.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PessoaRequest {

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private long idConta;
}

package com.stagproj.BankingAPI.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaRequest {

    private String nome;

    private String cpf;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;

    private long idConta;
}

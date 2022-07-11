package com.stagproj.BankingAPI.dtos.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaResponse {

    private String nome;

    private String cpf;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;

    private long idConta;
}

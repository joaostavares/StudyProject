package com.stagproj.BankingAPI.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
public class PessoaRequest {

    @NotEmpty(message = "O nome deve ser preenchido")
    private String nome;

    @CPF(message = "CPF invalido")
    private String cpf;

    @Past
    @NotNull(message = "A data de nascimento deve ser preenchida")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Min(value = 1, message = "O id da conta deve ser inserido")
    private long idConta;
}

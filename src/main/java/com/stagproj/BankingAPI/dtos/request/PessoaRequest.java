package com.stagproj.BankingAPI.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

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
    @NotEmpty(message = "O CPF não pode ser vazio")
    //@Size(min = 11, max = 11, message = "Insira todos os 11 digitos do cpf") //não deve ser necessaria no codigo final
    private String cpf;

    @Past
    @NotNull(message = "A data de nascimento deve ser preenchida")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;

    @NotEmpty
    private long idConta;
}

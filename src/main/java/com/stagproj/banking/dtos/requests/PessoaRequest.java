package com.stagproj.banking.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaRequest {

    @NotEmpty(message = "{pessoa.nome}")
    private String nome;

    @CPF(message = "{pessoa.cpf}")
    private String cpf;

    @Past
    @NotNull(message = "{pessoa.data}")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Min(value = 1, message = "{pessoa.conta}")
    private long idConta;
}

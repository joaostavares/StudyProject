package com.stagproj.banking.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Getter
@Setter

public class TransacaoRequest {

    @DecimalMin(value = "0.1", message = "{transacao.valor}")
    private double valor;

    @NotNull(message = "{transacao.data}")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataTransacao;

    @Min(value = 1, message = "{pessoa.conta}")
    private long idConta;

    @JsonIgnore
    private Long id;
}

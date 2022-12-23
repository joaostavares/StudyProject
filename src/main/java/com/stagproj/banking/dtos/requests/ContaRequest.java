package com.stagproj.banking.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
public class ContaRequest {
    private double saldo;

    @Min(value = 10, message = "{conta.limitesaque}")
    private double limiteSaqueDiario;

    private boolean flagAtivo;

    @Range(min = 1, max = 9, message = "{conta.tipo}")
    private int tipoConta;

    @NotNull(message = "{conta.data}")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataCriacao;
}

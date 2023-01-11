package com.studyproj.banking.dtos.reponses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContaResponse {
    private Long id;

    private double saldo;

    private double limiteSaqueDiario;

    private boolean flagAtivo;

    private int tipoConta;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataCriacao;
}

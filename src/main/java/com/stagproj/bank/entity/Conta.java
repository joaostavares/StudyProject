package com.stagproj.bank.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Conta {
    @Id
    @NonNull
    private long idConta;

    @NonNull
    private long idPessoa;

    @NonNull
    private double saldo;

    @NonNull
    private double limiteSaqueDiario;

    @NonNull
    private boolean flagAtivo;

    @NonNull
    private int tipoConta;

    @NonNull
    private String dataCriacao;
}

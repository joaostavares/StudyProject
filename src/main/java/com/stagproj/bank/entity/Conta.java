package com.stagproj.bank.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
    @Id
    @NonNull
    private long idConta;

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

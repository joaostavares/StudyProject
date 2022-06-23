package com.stagproj.bank.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    private Pessoa pessoa;
}

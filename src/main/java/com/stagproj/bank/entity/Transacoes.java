package com.stagproj.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transacoes {
    @Id
    @NonNull
    private long idTransacao;

    @NonNull
    @ManyToOne
    private Conta conta;

    @NonNull
    private int valor;

    @NonNull
    private String dataTransacao;

}

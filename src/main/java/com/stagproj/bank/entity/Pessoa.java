package com.stagproj.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idPessoa;

    @NonNull
    private String nome;

    @NonNull
    private String cpf;

    @NonNull
    private String dataNascimento;

    @OneToOne
    private Conta conta;
}

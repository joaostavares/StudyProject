package com.stagproj.BankingAPI.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty (message = "O saldo não pode ser vazio")
    private double saldo;

    @NotEmpty (message = "O Limite de saque diario não pode ser vazio")
    private double limiteSaqueDiario;

    @NonNull
    private boolean flagAtivo;

    @NotEmpty (message = "O tipo da conta não pode ser vazio")
    private int tipoConta;

    @NonNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataCriacao;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    @JsonBackReference
    private Pessoa pessoa;
}

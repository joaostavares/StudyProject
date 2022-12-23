package com.stagproj.banking.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private double saldo;

    @NonNull
    private double limiteSaqueDiario;

    @NonNull
    private boolean flagAtivo;

    @NonNull
    private int tipoConta;

    @NonNull
    private LocalDate dataCriacao;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    @JsonBackReference
    private Pessoa pessoa;
}

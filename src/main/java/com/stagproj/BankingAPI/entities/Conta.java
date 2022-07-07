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
import java.util.Date;

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
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataCriacao;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    @JsonBackReference
    private Pessoa pessoa;
}

package com.stagproj.BankingAPI.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @Min(value = 10, message = "O limite de saque minimo deve ser de 10")
    private double limiteSaqueDiario;

    @NonNull
    private boolean flagAtivo;

    @Range(min = 1, max = 9, message = "O tipo da conta deve ser entre 1 e 9")
    private int tipoConta;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataCriacao;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    @JsonBackReference
    private Pessoa pessoa;
}

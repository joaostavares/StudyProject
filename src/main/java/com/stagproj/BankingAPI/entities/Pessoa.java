package com.stagproj.BankingAPI.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;
import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "O nome deve ser preenchido")
    private String nome;

    @CPF (message = "CPF invalido")
    @NotEmpty(message = "O CPF não pode ser vazio")
    //@Size(min = 11, max = 11, message = "Insira todos os 11 digitos do cpf")
    private String cpf;

    @Past
    @NotNull(message = "A data de nascimento deve ser preenchida")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "Os dados pessoais devem referenciar a uma conta")
    @OneToOne
    @JoinColumn(name = "idConta", referencedColumnName = "id")
    @JsonManagedReference
    private Conta conta;
}

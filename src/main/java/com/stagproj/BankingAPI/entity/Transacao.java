package com.stagproj.BankingAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transacao {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransacao;

    @NonNull
    private double valor;

    @NonNull
    private String dataTransacao;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

}

package com.stagproj.BankingAPI.services;
import com.stagproj.BankingAPI.entities.Conta;
import java.util.List;

public interface ContaService {
    List<Conta> getAll();

    Conta getConta(long id);

    Conta criacaoConta(Conta conta);

    Conta bloqueioConta(long id);
}

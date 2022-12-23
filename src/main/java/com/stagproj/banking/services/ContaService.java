package com.stagproj.banking.services;
import com.stagproj.banking.entities.Conta;
import java.util.List;

public interface ContaService {
    List<Conta> getAll();

    Conta getConta(long id);

    Conta criacaoConta(Conta conta);

    Conta bloqueioConta(long id);
}

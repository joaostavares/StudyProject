package com.studyproj.banking.services;
import com.studyproj.banking.entities.Conta;
import java.util.List;

public interface ContaService {
    List<Conta> getAll();

    Conta getConta(long id);

    Conta criacaoConta(Conta conta);

    Conta bloqueioConta(long id);

    Boolean getAtividade(long id);
}

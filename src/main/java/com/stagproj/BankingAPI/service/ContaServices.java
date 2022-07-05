package com.stagproj.BankingAPI.service;
import com.stagproj.BankingAPI.dto.ContaDto;
import com.stagproj.BankingAPI.entity.Conta;
import java.util.List;

public interface ContaServices {
    List<Conta> getAll();

    Conta getConta(long id);

    ContaDto criacaoConta(Conta conta);

    Conta bloqueioConta(long id);
}

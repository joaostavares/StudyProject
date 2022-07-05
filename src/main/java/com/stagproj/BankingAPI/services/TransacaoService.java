package com.stagproj.BankingAPI.services;
import com.stagproj.BankingAPI.entities.Transacao;
import java.util.List;

public interface TransacaoService {
    Transacao deposito(Transacao transacao);

    Transacao saque(Transacao transacao);

    List<Transacao> extrato(long id);
}

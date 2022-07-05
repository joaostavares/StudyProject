package com.stagproj.BankingAPI.service;
import com.stagproj.BankingAPI.entity.Transacao;
import java.util.List;

public interface TransacaoServices {
    Transacao deposito(Transacao transacao);

    Transacao saque(Transacao transacao);

    List<Transacao> extrato(long id);
}

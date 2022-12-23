package com.stagproj.banking.services;
import com.stagproj.banking.entities.Transacao;
import java.util.List;

public interface TransacaoService {
    Transacao deposito(Transacao transacao);

    Transacao saque(Transacao transacao);

    List<Transacao> extrato(long id);
}

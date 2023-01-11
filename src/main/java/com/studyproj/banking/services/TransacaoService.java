package com.studyproj.banking.services;
import com.studyproj.banking.entities.Transacao;
import java.util.List;

public interface TransacaoService {
    Transacao deposito(Transacao transacao);

    Transacao saque(Transacao transacao);

    List<Transacao> extrato(long id);
}

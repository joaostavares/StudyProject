package com.stagproj.BankingAPI.services.impl;

import com.stagproj.BankingAPI.entities.Conta;
import com.stagproj.BankingAPI.entities.Transacao;
import com.stagproj.BankingAPI.repositories.ContaRepository;
import com.stagproj.BankingAPI.repositories.TransacaoRepository;
import com.stagproj.BankingAPI.services.TransacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {
    private final TransacaoRepository transacaoRepository;

    private final ContaRepository contaRepository;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
    }

    public Transacao deposito(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getId());
        conta.setSaldo(conta.getSaldo() + transacao.getValor());
        transacaoRepository.save(transacao);
        return transacao;
    }

    public Transacao saque(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getId());
        conta.setSaldo(conta.getSaldo() - transacao.getValor());
        transacaoRepository.save(transacao);
        return transacao;
    }

    public List<Transacao> extrato(long id) {
        Conta conta = contaRepository.getReferenceById(id);
        return transacaoRepository.findByConta(conta);
    }
}


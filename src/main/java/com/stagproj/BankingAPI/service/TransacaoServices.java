package com.stagproj.BankingAPI.service;

import com.stagproj.BankingAPI.entity.Conta;
import com.stagproj.BankingAPI.entity.Transacao;
import com.stagproj.BankingAPI.repository.ContaRepository;
import com.stagproj.BankingAPI.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServices {
    private final TransacaoRepository transacaoRepository;

    private final ContaRepository contaRepository;

    public TransacaoServices(TransacaoRepository transacaoRepository, ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
    }

    public Transacao deposito(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getIdConta());
        conta.setSaldo(conta.getSaldo() + transacao.getValor());
        transacaoRepository.save(transacao);
        return transacao;
    }

    public Transacao saque(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getIdConta());
        conta.setSaldo(conta.getSaldo() - transacao.getValor());
        transacaoRepository.save(transacao);
        return transacao;
    }

    public List<Transacao> extrato(long id) {
        Conta conta = contaRepository.getReferenceById(id);
        return transacaoRepository.findByConta(conta);
    }
}

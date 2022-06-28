package com.stagproj.bank.service;

import com.stagproj.bank.entity.Conta;
import com.stagproj.bank.entity.Transacoes;
import com.stagproj.bank.repository.ContaRepository;
import com.stagproj.bank.repository.TransacoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacoesServices {
    private final TransacoesRepository transacoesRepository;

    private final ContaRepository contaRepository;

    public TransacoesServices(TransacoesRepository transacoesRepository, ContaRepository contaRepository) {
        this.transacoesRepository = transacoesRepository;
        this.contaRepository = contaRepository;
    }

    public Transacoes deposito(Transacoes transacoes) {
        Conta conta = contaRepository.getReferenceById(transacoes.getConta().getIdConta());
        conta.setSaldo(conta.getSaldo() + transacoes.getValor());
        transacoesRepository.save(transacoes);
        return transacoes;
    }

    public Transacoes saque(Transacoes transacoes) {
        Conta conta = contaRepository.getReferenceById(transacoes.getConta().getIdConta());
        conta.setSaldo(conta.getSaldo() - transacoes.getValor());
        transacoesRepository.save(transacoes);
        return transacoes;
    }

    public Transacoes bloqueioConta(Transacoes transacoes) {
        Conta conta = contaRepository.getReferenceById(transacoes.getConta().getIdConta());
        if(!conta.isFlagAtivo()) {
            conta.setFlagAtivo(true);
        }
        transacoes.setValor(1);
        transacoesRepository.save(transacoes);
        return transacoes;
    }

    public List<Transacoes> extrato(long id) {
        Conta conta = contaRepository.getReferenceById(id);
        return transacoesRepository.findByConta(conta);
    }
}

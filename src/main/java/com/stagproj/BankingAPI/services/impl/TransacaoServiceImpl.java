package com.stagproj.BankingAPI.services.impl;

import com.stagproj.BankingAPI.entities.Conta;
import com.stagproj.BankingAPI.entities.Transacao;
import com.stagproj.BankingAPI.exceptions.ExceptionMethod;
import com.stagproj.BankingAPI.repositories.ContaRepository;
import com.stagproj.BankingAPI.repositories.TransacaoRepository;
import com.stagproj.BankingAPI.services.ContaService;
import com.stagproj.BankingAPI.services.TransacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TransacaoServiceImpl implements TransacaoService {
    private final TransacaoRepository transacaoRepository;

    private final ContaRepository contaRepository;

    private final ContaService contaService;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, ContaRepository contaRepository, ContaService contaService) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
        this.contaService = contaService;
    }

    public Transacao deposito(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getId());
        try {
            if (isNull(contaService.getConta(conta.getId()))) {
                throw new Exception("A conta não existe.");
            }
            conta.setSaldo(conta.getSaldo() + transacao.getValor());
            transacaoRepository.save(transacao);
            return transacao;
        }catch (Exception ee) {
            throw new ExceptionMethod(ee.getMessage());
        }
    }

    public Transacao saque(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getId());
        try {
            if (isNull(contaService.getConta(conta.getId()))) {
                throw new Exception("A conta não existe.");
            }
            conta.setSaldo(conta.getSaldo() - transacao.getValor());
            transacaoRepository.save(transacao);
            return transacao;
        }catch (Exception ee) {
            throw new ExceptionMethod(ee.getMessage());
        }
    }

    public List<Transacao> extrato(long id) {
        Conta conta = contaRepository.getReferenceById(id);
        try {
            if (isNull(contaService.getConta(conta.getId()))) {
                throw new Exception("A conta não existe.");
            }
            return transacaoRepository.findByConta(conta);
        }catch (Exception ee) {
            throw new ExceptionMethod(ee.getMessage());
        }
    }
}

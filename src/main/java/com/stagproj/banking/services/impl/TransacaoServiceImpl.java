package com.stagproj.banking.services.impl;

import com.stagproj.banking.entities.Conta;
import com.stagproj.banking.entities.Transacao;
import com.stagproj.banking.exceptions.ExceptionMethod;
import com.stagproj.banking.repositories.ContaRepository;
import com.stagproj.banking.repositories.TransacaoRepository;
import com.stagproj.banking.services.ContaService;
import com.stagproj.banking.services.TransacaoService;
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

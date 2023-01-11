package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Conta;
import com.studyproj.banking.entities.Transacao;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.ContaRepository;
import com.studyproj.banking.repositories.TransacaoRepository;
import com.studyproj.banking.services.ContaService;
import com.studyproj.banking.services.TransacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TransacaoServiceImpl implements TransacaoService {
    private final TransacaoRepository transacaoRepository;

    private final ContaRepository contaRepository;

    private final ContaService contaService;

    private static final String ERRO = "A conta não existe.";

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, ContaRepository contaRepository, ContaService contaService) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
        this.contaService = contaService;
    }

    public Transacao deposito(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getId());
        if (isNull(contaService.getConta(conta.getId()))) {
            throw new ExceptionMessage(ERRO);
        }
        conta.setSaldo(conta.getSaldo() + transacao.getValor());
        transacaoRepository.save(transacao);
        return transacao;
    }

    public Transacao saque(Transacao transacao) {
        Conta conta = contaRepository.getReferenceById(transacao.getConta().getId());
        if (isNull(contaService.getConta(conta.getId()))) {
            throw new ExceptionMessage(ERRO);
        }
        conta.setSaldo(conta.getSaldo() - transacao.getValor());
        transacaoRepository.save(transacao);
        return transacao;
    }

    public List<Transacao> extrato(long id) {
        Conta conta = contaRepository.getReferenceById(id);
        if (isNull(contaService.getConta(conta.getId()))) {
            throw new ExceptionMessage(ERRO);
        }
        return transacaoRepository.findByConta(conta);
    }
}

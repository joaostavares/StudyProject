package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Conta;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.ContaRepository;
import com.studyproj.banking.services.ContaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> getAll() {
        return contaRepository.findAll();
    }

    public Conta getConta(long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        return conta.orElse(null);
    }

    public Conta criacaoConta(Conta conta) {
        contaRepository.save(conta);
        return conta;
    }

    public Conta bloqueioConta(long id) {
        Conta conta = getConta(id);
        if (conta != null && !conta.isFlagAtivo()) {
            conta.setFlagAtivo(true);
            contaRepository.save(conta);
        }
        return conta;
    }

    public Boolean getAtividade(long id) {
        Conta conta = getConta(id);
        if (isNull(conta)) {
            throw new ExceptionMessage("A conta não existe.");
        }
        return conta.isFlagAtivo();

    }
}


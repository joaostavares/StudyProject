package com.stagproj.banking.services.impl;

import com.stagproj.banking.entities.Conta;
import com.stagproj.banking.exceptions.ExceptionMethod;
import com.stagproj.banking.repositories.ContaRepository;
import com.stagproj.banking.services.ContaService;
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
        try {
            Conta conta = getConta(id);
            if (isNull(conta)) {
                throw new Exception("A conta não existe.");
            }
            return conta.isFlagAtivo();
        } catch (Exception ee) {
            throw new ExceptionMethod(ee.getMessage());
        }
    }
}


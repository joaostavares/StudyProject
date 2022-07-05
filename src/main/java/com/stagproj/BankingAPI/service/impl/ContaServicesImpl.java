package com.stagproj.BankingAPI.service.impl;

import com.stagproj.BankingAPI.entity.Conta;
import com.stagproj.BankingAPI.repository.ContaRepository;
import com.stagproj.BankingAPI.service.ContaServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaServicesImpl implements ContaServices {

    private final ContaRepository contaRepository;

    public ContaServicesImpl(ContaRepository contaRepository) {
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
        if (conta != null) {
            if (!conta.isFlagAtivo()) {
                conta.setFlagAtivo(true);
                contaRepository.save(conta);
            }
        }
        return conta;
    }
}
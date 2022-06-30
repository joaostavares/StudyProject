package com.stagproj.bank.service;

import com.stagproj.bank.entity.Conta;
import com.stagproj.bank.entity.Transacao;
import com.stagproj.bank.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContaServices {

    private final ContaRepository contaRepository;

    public ContaServices(ContaRepository contaRepository) {
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

    public String bloqueioConta(long id) { //refazer esse metodo
        Conta conta = getConta(id);
        String resultado = "Conta Já Bloqueada";
        if(!conta.isFlagAtivo()) {
            conta.setFlagAtivo(true);
            contaRepository.save(conta);
            resultado = "Conta Bloqueada";
        }
        return resultado;
    }
}

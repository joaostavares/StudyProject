package com.stagproj.bank.service;

import com.stagproj.bank.entity.Conta;
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

    public Conta criacaoConta(Conta conta){
        boolean checagem = checagem(conta.getIdConta());
        if (!checagem){
            contaRepository.save(conta);
            return conta;
        }
        else{
            return null;
        }
    }

    public boolean checagem(long id){
        Optional<Conta> checagemExistencia = contaRepository.findById(id);
        return checagemExistencia.isPresent();
    }
}

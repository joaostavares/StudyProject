package com.stagproj.BankingAPI.service.impl;

import com.stagproj.BankingAPI.entity.Conta;
import com.stagproj.BankingAPI.entity.Pessoa;
import com.stagproj.BankingAPI.repository.PessoaRepository;
import com.stagproj.BankingAPI.service.PessoaServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServicesImpl implements PessoaServices {
    private final PessoaRepository pessoaRepository;

    public PessoaServicesImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoa(long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    public Pessoa criacaoDados(Pessoa pessoa) {
        Conta conta = pessoa.getConta();
        pessoa.setConta(conta);
        pessoaRepository.save(pessoa);
        return pessoa;

    }
}

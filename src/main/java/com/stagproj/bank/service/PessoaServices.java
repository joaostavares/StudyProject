package com.stagproj.bank.service;

import com.stagproj.bank.entity.Conta;
import com.stagproj.bank.entity.Pessoa;
import com.stagproj.bank.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServices {
    private final PessoaRepository pessoaRepository;
    private final ContaServices contaServices;

    public PessoaServices(PessoaRepository pessoaRepository, ContaServices contaServices) {
        this.pessoaRepository = pessoaRepository;
        this.contaServices = contaServices;
    }

    public List<Pessoa> getAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas;
    }

    public Pessoa getPessoa(long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.isPresent() ? pessoa.get() : null;
    }

    public Pessoa criacaoDados(Pessoa pessoa) {
        Conta conta = pessoa.getConta();
        pessoa.setConta(conta);
        pessoaRepository.save(pessoa);
        return pessoa;

    }
}

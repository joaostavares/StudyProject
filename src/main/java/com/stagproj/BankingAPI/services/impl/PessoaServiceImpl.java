package com.stagproj.BankingAPI.services.impl;

import com.stagproj.BankingAPI.entities.Conta;
import com.stagproj.BankingAPI.entities.Pessoa;
import com.stagproj.BankingAPI.exceptions.ExceptionMethod;
import com.stagproj.BankingAPI.repositories.PessoaRepository;
import com.stagproj.BankingAPI.services.ContaService;
import com.stagproj.BankingAPI.services.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class PessoaServiceImpl implements PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ContaService contaService;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, ContaService contaService) {
        this.pessoaRepository = pessoaRepository;
        this.contaService = contaService;
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
        try {
            if (nonNull(pessoaRepository.findByConta_Id(conta.getId()))) {
                throw new Exception("Essa conta já contem dados pessoais");
            }
            if (isNull(contaService.getConta(conta.getId()))) {
                throw new Exception("A conta não existe.");
            }
            if (nonNull(pessoaRepository.findByCpf(pessoa.getCpf()))) {
                throw new Exception("O Cpf inserido ja pertence a outro pessoa.");
            }
            pessoa.setConta(conta);
            pessoaRepository.save(pessoa);
            return pessoa;
        }catch (Exception ee) {
            throw new ExceptionMethod(ee.getMessage());
        }
    }

}

package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Conta;
import com.studyproj.banking.entities.Pessoa;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.PessoaRepository;
import com.studyproj.banking.services.ContaService;
import com.studyproj.banking.services.PessoaService;
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
        if (nonNull(pessoaRepository.findByContaId(conta.getId()))) {
            throw new ExceptionMessage("Essa conta já contem dados pessoais");
        }
        if (isNull(contaService.getConta(conta.getId()))) {
            throw new ExceptionMessage("A conta não existe.");
        }
        if (nonNull(pessoaRepository.findByCpf(pessoa.getCpf()))) {
            throw new ExceptionMessage("O Cpf inserido ja pertence a outro pessoa.");
        }
        pessoa.setConta(conta);
        pessoaRepository.save(pessoa);
        return pessoa;
    }

}

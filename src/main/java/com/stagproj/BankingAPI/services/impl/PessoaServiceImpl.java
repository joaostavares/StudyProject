package com.stagproj.BankingAPI.services.impl;

import com.stagproj.BankingAPI.entities.Conta;
import com.stagproj.BankingAPI.entities.Pessoa;
import com.stagproj.BankingAPI.repositories.PessoaRepository;
import com.stagproj.BankingAPI.services.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class PessoaServiceImpl implements PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoa(long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    public Pessoa criacaoDados(Pessoa pessoa) throws Exception{
        Conta conta = pessoa.getConta();
        pessoa.setConta(conta);
        try {
            if (nonNull(pessoaRepository.findByCpf(pessoa.getCpf()))) {
                throw new Exception("O Cpf inserido ja pertence a outro pessoa.");
            }
            pessoaRepository.save(pessoa);
            return pessoa;
        }catch (Exception ee) {
            throw new Exception(ee.getMessage());
        }
    }

}

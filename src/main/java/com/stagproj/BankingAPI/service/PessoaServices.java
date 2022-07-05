package com.stagproj.BankingAPI.service;
import com.stagproj.BankingAPI.entity.Pessoa;
import java.util.List;


public interface PessoaServices {
    List<Pessoa> getAll();

    Pessoa getPessoa(long id);

    Pessoa criacaoDados(Pessoa pessoa);
}

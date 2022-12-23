package com.stagproj.banking.services;
import com.stagproj.banking.entities.Pessoa;
import java.util.List;


public interface PessoaService {
    List<Pessoa> getAll();

    Pessoa getPessoa(long id);

    Pessoa criacaoDados(Pessoa pessoa) throws Exception;
}

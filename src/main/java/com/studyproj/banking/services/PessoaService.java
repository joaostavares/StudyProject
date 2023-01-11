package com.studyproj.banking.services;
import com.studyproj.banking.entities.Pessoa;
import com.studyproj.banking.exceptions.ExceptionMessage;

import java.util.List;


public interface PessoaService {
    List<Pessoa> getAll();

    Pessoa getPessoa(long id);

    Pessoa criacaoDados(Pessoa pessoa) throws ExceptionMessage;
}

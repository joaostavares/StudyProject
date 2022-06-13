package com.stagproj.bank.controller;

import com.stagproj.bank.repository.ContaRepository;
import com.stagproj.bank.repository.PessoaRepository;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContaController {

    private final ContaRepository contaRepository;
    private final PessoaRepository pessoaRepository;

    public ContaController(ContaRepository contaRepository, PessoaRepository pessoaRepository) {
        this.contaRepository = contaRepository;
        this.pessoaRepository = pessoaRepository;
    }


}

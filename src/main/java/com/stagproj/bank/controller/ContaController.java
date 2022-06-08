package com.stagproj.bank.controller;

import com.stagproj.bank.repository.ContaRepository;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContaController {

    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }



}

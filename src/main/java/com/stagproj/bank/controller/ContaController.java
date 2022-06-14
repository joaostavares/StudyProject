package com.stagproj.bank.controller;

import com.stagproj.bank.entity.Conta;
import com.stagproj.bank.repository.ContaRepository;
import com.stagproj.bank.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
public class ContaController {

    private final ContaRepository contaRepository;
    private final PessoaRepository pessoaRepository;

    public ContaController(ContaRepository contaRepository, PessoaRepository pessoaRepository) {
        this.contaRepository = contaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @RequestMapping(value = "/conta", method = RequestMethod.GET)
    public List<Conta> Get() {
        return contaRepository.findAll();
    }

    @RequestMapping(value = "/conta/{idConta}", method = RequestMethod.GET)
    public ResponseEntity<Conta> GetById(@PathVariable(value = "idConta") long idConta)
    {
        Optional<Conta> conta = contaRepository.findById(idConta);
        return conta.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/conta", method = RequestMethod.POST)
    public ResponseEntity<Conta> post(@Valid @RequestBody Conta conta) {
        Optional<Conta> checagem = contaRepository.findById(conta.getIdConta());
        if (checagem.isPresent())
            return new ResponseEntity<Conta>(HttpStatus.FORBIDDEN);
        else
            contaRepository.save(conta);
            return new ResponseEntity<Conta>(HttpStatus.OK);
    }

}

package com.stagproj.bank.controller;

import com.stagproj.bank.entity.Pessoa;
import com.stagproj.bank.service.PessoaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaServices pessoaServices;

    public PessoaController(PessoaServices pessoaServices) {
        this.pessoaServices = pessoaServices;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> valores = pessoaServices.getAll();
        return new ResponseEntity<>(valores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable long id) {
        Pessoa pessoa = pessoaServices.getPessoa(id);
        return new ResponseEntity<>(pessoa, (pessoa != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Pessoa> post(@Valid @RequestBody Pessoa pessoa) {
        Pessoa criacao = pessoaServices.criacaoDados(pessoa);
        if (criacao == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(criacao, HttpStatus.OK);
        }
    }
}

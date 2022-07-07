package com.stagproj.BankingAPI.controllers;

import com.stagproj.BankingAPI.dtos.Reponse.PessoaResponse;
import com.stagproj.BankingAPI.dtos.Reponse.TransacaoResponse;
import com.stagproj.BankingAPI.dtos.Request.PessoaRequest;
import com.stagproj.BankingAPI.entities.Pessoa;
import com.stagproj.BankingAPI.services.PessoaService;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;
    private final ModelMapper modelMapper;

    public PessoaController(PessoaService pessoaService, ModelMapper modelMapper) {
        this.pessoaService = pessoaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> valores = pessoaService.getAll();
        return new ResponseEntity<>(valores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable long id) {
        Pessoa pessoa = pessoaService.getPessoa(id);
        return new ResponseEntity<>(pessoa, (pessoa != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<PessoaResponse> post(@Valid @RequestBody PessoaRequest pessoaRequest) {

        Pessoa pessoa = modelMapper.map(pessoaRequest, Pessoa.class);
        Pessoa criacao = pessoaService.criacaoDados(pessoa);
        PessoaResponse pessoaResponse = modelMapper.map(criacao, PessoaResponse.class);

        if (criacao == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(pessoaResponse, HttpStatus.CREATED);
        }
    }
}

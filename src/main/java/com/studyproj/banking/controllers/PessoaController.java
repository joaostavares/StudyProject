package com.studyproj.banking.controllers;

import com.studyproj.banking.dtos.reponses.PessoaResponse;
import com.studyproj.banking.dtos.requests.PessoaRequest;
import com.studyproj.banking.entities.Pessoa;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.services.PessoaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PessoaResponse> post(@Valid @RequestBody PessoaRequest pessoaRequest) throws ExceptionMessage {

        Pessoa pessoa = modelMapper.map(pessoaRequest, Pessoa.class);
        Pessoa criacao = pessoaService.criacaoDados(pessoa);
        PessoaResponse pessoaResponse = modelMapper.map(criacao, PessoaResponse.class);
        return new ResponseEntity<>(pessoaResponse, (criacao != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

}

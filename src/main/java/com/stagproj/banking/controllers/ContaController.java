package com.stagproj.banking.controllers;

import com.stagproj.banking.dtos.reponses.ContaResponse;
import com.stagproj.banking.dtos.requests.ContaRequest;
import com.stagproj.banking.entities.Conta;
import com.stagproj.banking.services.ContaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;
    private final ModelMapper modelMapper;

    public ContaController(ContaService contaService, ModelMapper modelMapper) {
        this.contaService = contaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> get() {
        List<Conta> valores = contaService.getAll();
        return new ResponseEntity<>(valores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById(@PathVariable long id) {
        Conta conta = contaService.getConta(id);
        return new ResponseEntity<>(conta, (conta != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ContaResponse> post(@Valid @RequestBody ContaRequest contaRequest) {
        Conta conta = modelMapper.map(contaRequest, Conta.class);
        Conta criacao = contaService.criacaoConta(conta);
        ContaResponse contaResponse = modelMapper.map(criacao, ContaResponse.class);

        return new ResponseEntity<>(contaResponse, (criacao == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED ));
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<Double> saldo(@PathVariable long id) {
        Conta contaSaldo = contaService.getConta(id);
        if (contaSaldo != null) {
            return new ResponseEntity<>(contaSaldo.getSaldo(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/travamento/{id}")
    public ResponseEntity<HttpStatus> travamento(@PathVariable long id) {
        Conta travamento = contaService.bloqueioConta(id);
        return new ResponseEntity<>(travamento != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/atividade/{id}")
    public ResponseEntity<Boolean> checagemDeTravamento(@PathVariable long id) {
        Boolean atividade = contaService.getAtividade(id);
        return new ResponseEntity<>(atividade, atividade != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }
}

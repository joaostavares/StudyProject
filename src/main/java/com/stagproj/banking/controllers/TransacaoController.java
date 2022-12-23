package com.stagproj.banking.controllers;

import com.stagproj.banking.dtos.reponses.TransacaoResponse;
import com.stagproj.banking.dtos.requests.TransacaoRequest;
import com.stagproj.banking.entities.Transacao;
import com.stagproj.banking.services.TransacaoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final ModelMapper modelMapper;

    public TransacaoController(TransacaoService transacaoService, ModelMapper modelMapper) {
        this.transacaoService = transacaoService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/extrato/{id}")
    public ResponseEntity<List<Transacao>> extrato(@PathVariable long id) {
        List<Transacao> extrato = transacaoService.extrato(id);
        return new ResponseEntity<>(extrato, (!extrato.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/deposito")
    public ResponseEntity<TransacaoResponse> deposito(@Valid @RequestBody TransacaoRequest transacaoRequest) {
        Transacao transacao = modelMapper.map(transacaoRequest, Transacao.class);
        Transacao deposito = transacaoService.deposito(transacao);
        TransacaoResponse transacaoResponse = modelMapper.map(deposito, TransacaoResponse.class);
        return new ResponseEntity<>(transacaoResponse, HttpStatus.OK );
    }

    @PostMapping(value = "/saque")
    public ResponseEntity<TransacaoResponse> saque(@Valid @RequestBody TransacaoRequest transacaoRequest) {
        Transacao transacao = modelMapper.map(transacaoRequest, Transacao.class);
        Transacao saque = transacaoService.saque(transacao);
        TransacaoResponse transacaoResponse = modelMapper.map(saque, TransacaoResponse.class);
        return new ResponseEntity<>(transacaoResponse, HttpStatus.OK );
    }

}

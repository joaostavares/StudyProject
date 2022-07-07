package com.stagproj.BankingAPI.controllers;

import com.stagproj.BankingAPI.dtos.Reponse.TransacaoResponse;
import com.stagproj.BankingAPI.dtos.Request.TransacaoRequest;
import com.stagproj.BankingAPI.entities.Transacao;
import com.stagproj.BankingAPI.services.TransacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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
        return new ResponseEntity<>(extrato, (extrato != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
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

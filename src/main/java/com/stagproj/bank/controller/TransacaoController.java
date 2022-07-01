package com.stagproj.bank.controller;

import com.stagproj.bank.entity.Transacao;
import com.stagproj.bank.service.TransacaoServices;
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

    private final TransacaoServices transacaoServices;

    public TransacaoController(TransacaoServices transacaoServices) {
        this.transacaoServices = transacaoServices;
    }
    @GetMapping("/extrato/{id}")
    public ResponseEntity<?> extrato(@PathVariable long id) {
        List<Transacao> extrato = transacaoServices.extrato(id);
        return new ResponseEntity<>(extrato, (extrato != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/deposito")
    public ResponseEntity<Transacao> deposito(@Valid @RequestBody Transacao transacao) {
        Transacao deposito = transacaoServices.deposito(transacao);
        return new ResponseEntity<>(deposito, HttpStatus.OK );
    }

    @PostMapping(value = "/saque")
    public ResponseEntity<Transacao> saque(@Valid @RequestBody Transacao transacao) {
        Transacao saque = transacaoServices.saque(transacao);
        return new ResponseEntity<>(saque, HttpStatus.OK );
    }

}

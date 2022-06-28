package com.stagproj.bank.controller;

import com.stagproj.bank.entity.Transacoes;
import com.stagproj.bank.service.TransacoesServices;
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
public class TransacoesController {

    private final TransacoesServices transacoesServices;

    public TransacoesController(TransacoesServices transacoesServices) {
        this.transacoesServices = transacoesServices;
    }
    @GetMapping("/extrato/{id}")
    public ResponseEntity<?> extrato(@PathVariable long id) {
        List<Transacoes> extrato = transacoesServices.extrato(id);
        return new ResponseEntity<>(extrato, (extrato != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/deposito")
    public ResponseEntity<Transacoes> deposito(@Valid @RequestBody Transacoes transacoes) {
        Transacoes deposito = transacoesServices.deposito(transacoes);
        return new ResponseEntity<>(deposito, HttpStatus.OK );
    }

    @PostMapping(value = "/saque")
    public ResponseEntity<Transacoes> saque(@Valid @RequestBody Transacoes transacoes) {
        Transacoes saque = transacoesServices.saque(transacoes);
        return new ResponseEntity<>(saque, HttpStatus.OK );
    }

    @PostMapping(value = "/travamento")
    public ResponseEntity<Transacoes> travamento(@Valid @RequestBody Transacoes transacoes) {
        Transacoes travamento = transacoesServices.bloqueioConta(transacoes);
        return new ResponseEntity<>(travamento, HttpStatus.OK );
    }
}

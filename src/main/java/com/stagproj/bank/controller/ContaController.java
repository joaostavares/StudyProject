package com.stagproj.bank.controller;

import com.stagproj.bank.entity.Conta;
import com.stagproj.bank.service.ContaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaServices contaServices;

    public ContaController(ContaServices contaServices) {
        this.contaServices = contaServices;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> get() {
        List<Conta> valores = contaServices.getAll();
        return new ResponseEntity<>(valores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById(@PathVariable long id) {
        Conta conta = contaServices.getConta(id);
        return new ResponseEntity<>(conta, (conta != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Conta> post(@Valid @RequestBody Conta conta) {
        Conta criacao = contaServices.criacaoConta(conta);
        return new ResponseEntity<>(criacao, (criacao == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK ));
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<?> saldo(@PathVariable long id) {
        Conta conta = contaServices.getConta(id);
        return new ResponseEntity<>(conta.getSaldo(), (conta != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/travamento/{id}")
    public ResponseEntity<?> travamento(@PathVariable long id) {
        String travamento = contaServices.bloqueioConta(id);
        return new ResponseEntity<>(travamento, HttpStatus.OK );
    }

    @GetMapping("/atividade/{id}")
    public ResponseEntity<?> checagemDeTravamento(@PathVariable long id) {
        Conta conta = contaServices.getConta(id);
        return new ResponseEntity<>(conta.isFlagAtivo(), (conta != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }
}

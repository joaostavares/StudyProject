package com.stagproj.BankingAPI.controller;

import com.stagproj.BankingAPI.entity.Conta;
import com.stagproj.BankingAPI.service.ContaServices;
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
@RequestMapping("/contas")
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
    public ResponseEntity<Double> saldo(@PathVariable long id) {
        Conta contaSaldo = contaServices.getConta(id);
        if (contaSaldo != null) {
            return new ResponseEntity<>(contaSaldo.getSaldo(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/travamento/{id}")
    public ResponseEntity<HttpStatus> travamento(@PathVariable long id) {
        Conta travamento = contaServices.bloqueioConta(id);
        return new ResponseEntity<>(travamento != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/atividade/{id}")
    public ResponseEntity<Boolean> checagemDeTravamento(@PathVariable long id) {
        Conta atividade = contaServices.getConta(id);
        return new ResponseEntity<>(atividade != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

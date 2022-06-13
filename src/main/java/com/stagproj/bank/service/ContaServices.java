package com.stagproj.bank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stagproj.bank.entity.Conta;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaServices {
    private List<Conta> contas;


    public boolean isJSONValid(String jsonInString) {
        try {
            return new ObjectMapper().readTree(jsonInString) != null;
        } catch (IOException e) {
            return false;
        }
    }

    private long parseId(JSONObject contas) {
        return Long.valueOf((int) contas.get("idConta"));
    }

    private LocalDateTime parseDataCriacao(JSONObject contas) {
        var dataCriacao = (String) contas.get("dataCriacao");
        return ZonedDateTime.parse(dataCriacao).toLocalDateTime();
    }

    private void setConta(JSONObject jsonConta, Conta conta) {
        Double saldo = (double) jsonConta.get("saldo");
        Double limiteSaqueDiario = (double) jsonConta.get("limiteSaqueDiario");
        boolean flagAtivo = (boolean) jsonConta.get("flagAtivo");
        String tipoConta = (String) jsonConta.get("tipoConta");

        conta.setSaldo(saldo != null ? saldo : conta.getSaldo());
        conta.setLimiteSaqueDiario(limiteSaqueDiario != null ? limiteSaqueDiario : conta.getLimiteSaqueDiario());
        conta.setFlagAtivo(conta.isFlagAtivo());
        conta.setDataCriacao(jsonConta.get("dataCriacao") != null ? String.valueOf(parseDataCriacao(jsonConta)) : conta.getDataCriacao());
        conta.setTipoConta(tipoConta != null ? Integer.valueOf(tipoConta) : conta.getTipoConta());
    }

}

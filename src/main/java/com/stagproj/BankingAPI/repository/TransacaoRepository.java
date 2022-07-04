package com.stagproj.BankingAPI.repository;

import com.stagproj.BankingAPI.entity.Conta;
import com.stagproj.BankingAPI.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByConta(Conta conta);
}

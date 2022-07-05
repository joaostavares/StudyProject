package com.stagproj.BankingAPI.repositories;

import com.stagproj.BankingAPI.entities.Conta;
import com.stagproj.BankingAPI.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByConta(Conta conta);
}

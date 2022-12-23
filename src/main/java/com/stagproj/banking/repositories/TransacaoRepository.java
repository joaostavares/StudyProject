package com.stagproj.banking.repositories;

import com.stagproj.banking.entities.Conta;
import com.stagproj.banking.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByConta(Conta conta);
}

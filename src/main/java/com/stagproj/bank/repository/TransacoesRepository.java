package com.stagproj.bank.repository;

import com.stagproj.bank.entity.Conta;
import com.stagproj.bank.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
    List<Transacoes> findByConta(Conta conta);
}

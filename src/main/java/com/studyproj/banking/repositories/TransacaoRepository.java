package com.studyproj.banking.repositories;

import com.studyproj.banking.entities.Conta;
import com.studyproj.banking.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByConta(Conta conta);
}

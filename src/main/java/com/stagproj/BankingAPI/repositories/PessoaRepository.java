package com.stagproj.BankingAPI.repositories;

import com.stagproj.BankingAPI.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);

    Pessoa findByConta_Id(Long idConta);
}
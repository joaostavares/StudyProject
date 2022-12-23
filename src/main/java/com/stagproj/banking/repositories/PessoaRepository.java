package com.stagproj.banking.repositories;

import com.stagproj.banking.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);

    Pessoa findByContaId(Long idConta);
}
package com.studyproj.banking.repositories;

import com.studyproj.banking.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);

    Pessoa findByContaId(Long idConta);
}
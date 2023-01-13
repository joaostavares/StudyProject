package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.entities.Person;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.PersonRepository;
import com.studyproj.banking.services.AccountService;
import com.studyproj.banking.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final AccountService accountService;

    public PersonServiceImpl(PersonRepository personRepository, AccountService accountService) {
        this.personRepository = personRepository;
        this.accountService = accountService;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    public Person personCreation(Person person) {
        Account account = person.getAccount();
        if (nonNull(personRepository.findByAccountId(account.getId()))) {
            throw new ExceptionMessage("This account already contains personal data");
        }
        if (isNull(accountService.getAccount(account.getId()))) {
            throw new ExceptionMessage("Account does not exist.");
        }
        if (nonNull(personRepository.findByCpf(person.getCpf()))) {
            throw new ExceptionMessage("The CPF entered already belongs to another person.");
        }
        person.setAccount(account);
        personRepository.save(person);
        return person;
    }

}

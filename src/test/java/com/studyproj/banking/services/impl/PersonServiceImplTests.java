package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.entities.Person;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.AccountRepository;
import com.studyproj.banking.repositories.PersonRepository;
import com.studyproj.banking.services.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTests {

    private PersonServiceImpl personService;

    private PersonRepository personRepository;

    private AccountService accountService;

    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        accountService = new AccountServiceImpl(accountRepository);
        personRepository = Mockito.mock(PersonRepository.class);
        personService = new PersonServiceImpl(personRepository, accountService);
    }

    @Test
    void getsuccessGetAllPerson() {
        Person person1 = mock(Person.class);
        Person person2 = mock(Person.class);

        when(personService.getAll()).thenReturn(List.of(person1, person2));


        Assertions.assertDoesNotThrow(() -> personService.getAll());
        Assertions.assertEquals(2, personService.getAll().size());
    }

    @Test
    void getSuccessPersonById() {
        Person person = mock(Person.class);

        when(personRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(person));

        Assertions.assertDoesNotThrow(() -> personService.getPersonById(Mockito.anyLong()));
    }

    @Test
    void getSuccessWhenCreateANewPerson() {
        Person person = new Person();
        Account account = new Account();
        account.setId(1L);
        person.setAccount(account);

        when(personRepository.findByAccountId(Mockito.anyLong())).thenReturn(null);
        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));

        Assertions.assertDoesNotThrow(() -> personService.createPerson(person));
    }

    @Test
    void getAccountAlreadyHasPersonalDataWhenCreateANewPerson() {
        Person person = new Person();
        Account account = new Account();
        account.setId(1L);
        person.setAccount(account);

        when(personRepository.findByAccountId(Mockito.anyLong())).thenReturn(mock(Person.class));

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> personService.createPerson(person), "This account already contains personal data");

    }

    @Test
    void getAccountDontExistWhenCreateANewPerson() {
        Person person = new Person();
        Account account = new Account();
        account.setId(1L);
        person.setAccount(account);

        when(personRepository.findByAccountId(Mockito.anyLong())).thenReturn(mock(Person.class));

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> personService.createPerson(person), "Account does not exist.");

    }

    @Test
    void getCpfAlreadyExitsWhenCreateANewPerson() {
        Person person = new Person();
        Account account = new Account();
        account.setId(1L);
        person.setAccount(account);

        when(personRepository.findByAccountId(Mockito.anyLong())).thenReturn(null);
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(account));
        when(personRepository.findByCpf(person.getCpf())).thenReturn(mock(Person.class));

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> personService.createPerson(person), "The CPF entered already belongs to another person.");
    }

}

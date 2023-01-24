package com.studyproj.banking.controllers;

import com.studyproj.banking.core.ModelMapperConfig;
import com.studyproj.banking.entities.Account;
import com.studyproj.banking.repositories.AccountRepository;
import com.studyproj.banking.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AccountController.class, AccountService.class, ModelMapperConfig.class})
@WebMvcTest
class AccountControllerTests {

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAccountsWhenGetAllAccounts() throws Exception {
        Account account1 = new Account();
        Account account2 = new Account();

        when(accountRepository.findAll()).thenReturn(List.of(account1, account2));
        when(accountService.getAll()).thenReturn(List.of(account1, account2));

        mockMvc.perform(MockMvcRequestBuilders.get("/account"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void shouldSuccessfulReturnAccountWhenGetAccountById() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setBlocked(false);
        account.setAccountType(1);
        account.setBalance(1000.0);
        account.setCreationDate(LocalDate.now());

        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));
        when(accountService.getAccount(account.getId())).thenReturn(account);

        mockMvc.perform(MockMvcRequestBuilders.get("/account/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.blocked").value(false))
                .andExpect(jsonPath("$.accountType").value(1))
                .andExpect(jsonPath("$.balance").value(1000.0))
                .andExpect(jsonPath("$.creationDate").value(LocalDate.now().toString()));

    }

}

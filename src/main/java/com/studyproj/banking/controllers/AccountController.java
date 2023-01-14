package com.studyproj.banking.controllers;

import com.studyproj.banking.dtos.reponses.AccountResponse;
import com.studyproj.banking.dtos.requests.AccountRequest;
import com.studyproj.banking.entities.Account;
import com.studyproj.banking.services.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Account", description = "Account Controller")
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;

    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<Account>> get() {
        List<Account> accounts = accountService.getAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable long id) {
        Account account = accountService.getAccount(id);
        return new ResponseEntity<>(account, (account != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AccountResponse> post(@Valid @RequestBody AccountRequest accountRequest) {
        Account account = modelMapper.map(accountRequest, Account.class);
        Account creation = accountService.createAccount(account);
        AccountResponse accountResponse = modelMapper.map(creation, AccountResponse.class);

        return new ResponseEntity<>(accountResponse, (creation == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED ));
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<Double> saldo(@PathVariable long id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/block/{id}")
    public ResponseEntity<HttpStatus> block(@PathVariable long id) {
        Account blockAccount = accountService.blockAccount(id);
        return new ResponseEntity<>(blockAccount != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/unblock/{id}")
    public ResponseEntity<HttpStatus> unblock(@PathVariable long id) {
        Account unblockAccount = accountService.unblockAccount(id);
        return new ResponseEntity<>(unblockAccount != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/isblocked/{id}")
    public ResponseEntity<Boolean> activityCheck(@PathVariable long id) {
        Boolean activity = accountService.getBlockedStatus(id);
        return new ResponseEntity<>(activity, activity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }
}

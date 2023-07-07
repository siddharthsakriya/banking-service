package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }
}

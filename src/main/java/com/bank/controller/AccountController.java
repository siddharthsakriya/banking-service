package com.bank.controller;

import com.bank.converter.AccountConverter;
import com.bank.model.Account;
import com.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/getaccounts")
    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @RequestMapping("/addaccount")
    @PostMapping
    public Account addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

}

package com.bank.controller;

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
    @RequestMapping(method = RequestMethod.GET, value = "/getaccount/{id}")
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.getAccountById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/addaccount")
    public int addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }
    @RequestMapping(method = RequestMethod.DELETE, value= "/deleteaccount/{id}")
    public void deleteAccount(@PathVariable("id") int id){
        accountService.deleteAccount(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/updateaccount")
    public  void  updateAccount(@RequestBody Account account){
        accountService.updateAccount(account);
    }
}

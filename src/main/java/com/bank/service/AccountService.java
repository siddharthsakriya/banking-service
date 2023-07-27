package com.bank.service;

import com.bank.converter.AccountConverter;
import com.bank.db.repository.AccountRepository;
import com.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public List<Account> getAccounts(){
        return AccountConverter.convertToModel(accountRepository.findAll());
    }

    public void addAccount(Account account){
        accountRepository.save(AccountConverter.convertToEntity(account));
    }
}

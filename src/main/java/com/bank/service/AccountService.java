package com.bank.service;

import com.bank.converter.AccountConverter;
import com.bank.db.repository.AccountRepository;
import com.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public List<Account> getAccounts(){
        return AccountConverter.convertToModel(accountRepository.findAll());
    }
    public Account getAccountById(int id){
        Optional<com.bank.db.entity.Account> account = accountRepository.findById(id);
        if (account.isPresent()){
            return AccountConverter.convertToModel(account.get());
        }
        throw new RuntimeException("Account not found");
    }
    public int addAccount(Account account){
        return accountRepository.save(AccountConverter.convertToEntity(account)).getAccountID();
    }
    public void deleteAccount(int id){
        accountRepository.deleteById(id);
    }
}

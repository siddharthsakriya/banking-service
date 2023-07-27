package com.bank.converter;

import com.bank.model.Account;

import java.util.ArrayList;
import java.util.List;
public class AccountConverter {

    public static List<Account> convertToModel(Iterable<com.bank.db.entity.Account> accounts){
        List<com.bank.model.Account> modelAccounts = new ArrayList<>();
        for(com.bank.db.entity.Account account : accounts){
            modelAccounts.add(convertToModel(account));
        }
        return modelAccounts;
    }

    public static com.bank.model.Account convertToModel(com.bank.db.entity.Account account) {
        com.bank.model.Account modelAccounts = new com.bank.model.Account();
        modelAccounts.setAccountID(account.getAccountID());
        modelAccounts.setCustomerID(account.getCustomerID());
        modelAccounts.setBalance(account.getBalance());
        modelAccounts.setCurrency(account.getCurrency());
        return modelAccounts;
    }

    public static List<com.bank.db.entity.Account> convertToEntity(Iterable<com.bank.model.Account> accounts){
        List<com.bank.db.entity.Account> entityAccounts = new ArrayList<>();
        for(com.bank.model.Account account : accounts){
            entityAccounts.add(convertToEntity(account));
        }
        return entityAccounts;
    }

    public static com.bank.db.entity.Account convertToEntity(com.bank.model.Account account) {
        com.bank.db.entity.Account entityAccount = new com.bank.db.entity.Account();
        entityAccount.setAccountID(account.getAccountID());
        entityAccount.setCustomerID(account.getCustomerID());
        entityAccount.setBalance(account.getBalance());
        entityAccount.setCurrency(account.getCurrency());
        return entityAccount;
    }
}

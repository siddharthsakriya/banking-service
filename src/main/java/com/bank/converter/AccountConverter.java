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
        com.bank.model.Account modelAccounts= new com.bank.model.Account();
        modelAccounts.setAccountID(account.getAccountID());
        modelAccounts.setCustomerID(account.getCustomerID());
        modelAccounts.setAccountType(account.getAccountType());
        modelAccounts.setBalance(account.getBalance());
        modelAccounts.setCurrency(account.getCurrency());
        return modelAccounts;
    }
}

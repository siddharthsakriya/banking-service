package com.bank.model;

import com.bank.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private int accountID;
    private int customerID;
    private double balance;
    private String currency;

    public Account() {
    }

    public Account(int accountID,
                   int customerID,
                   double balance,
                   String currency) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.balance = balance;
        this.currency = currency;
    }

    public Account(int customerID,
                   double balance,
                   String currency) {
        this.customerID = customerID;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", customerID=" + customerID +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}

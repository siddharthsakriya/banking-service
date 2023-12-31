package com.bank.db.entity;

import com.bank.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int accountID;
    private int customerID;
    private double balance;
    private String currency;

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

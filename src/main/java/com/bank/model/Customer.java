package com.bank.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private LocalDate dob;

    public Customer() {
    }

    public Customer(int id,
                    String name,
                    String address,
                    String phone,
                    String email,
                    LocalDate dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public Customer(String name,
                    String address,
                    String phone,
                    String email,
                    LocalDate dob) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }

}

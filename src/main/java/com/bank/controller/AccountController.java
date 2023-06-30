package com.bank.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    @GetMapping("/account")
    public String getAccount(@RequestParam(value = "accNumber") int accNumber) {
        return "{" + "\"accountNumber\":" + accNumber + ",\"balance\":1000.00,\"accountType\":\"savings\"}";
    }
}

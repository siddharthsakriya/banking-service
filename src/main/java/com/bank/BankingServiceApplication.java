package com.bank;

import com.bank.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class BankingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingServiceApplication.class, args);
    }
    @GetMapping
    public List<Customer> hello(){
        return List.of(
                new Customer(1, "John", "John", "123 Main St", "123-456-7890", LocalDate.of(2003, Month.OCTOBER, 01))
        );
    }
}

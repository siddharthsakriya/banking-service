package com.bank.controller;

import com.bank.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class CustomerController {
    @RequestMapping("api/v1/customer")
    public List<Customer> getCustomers(){
        return List.of(
            new Customer(
                    1,
                    "John Doe",
                    "John Doe",
                    "25 Glove Street",
                    "1299292",
                    LocalDate.of(2003, Month.APRIL, 9 )
            )
        );
    }
}

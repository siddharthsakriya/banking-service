package com.bank.service;

import com.bank.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CustomerService {
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

package com.bank.service;

import com.bank.converter.CustomerConverter;
import com.bank.db.repository.CustomerRepository;
import com.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return CustomerConverter.convertToModel(customerRepository.findAll());
    }
}

package com.bank.service;

import com.bank.converter.CustomerConverter;
import com.bank.db.entity.Account;
import com.bank.db.repository.CustomerRepository;
import com.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return CustomerConverter.convertToModel(customerRepository.findAll());
    }
    public Customer getCustomerById(int id){
        Optional<com.bank.db.entity.Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return CustomerConverter.convertToModel(customer.get());
        }
        throw new RuntimeException("Account not found");
    }


}

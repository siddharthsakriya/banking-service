package com.bank.controller;

import com.bank.model.Customer;
import com.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/getcustomers")
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @RequestMapping("/getcustomerbyid/{id}")
    @GetMapping
    public Customer getCustomerById(@PathVariable("id") int id){
        return customerService.getCustomerById(id);
    }




}

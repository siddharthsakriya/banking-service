package com.bank.converter;

import com.bank.model.Customer;

import java.util.ArrayList;
import java.util.List;
public class CustomerConverter {

    public static List<Customer> convertToModel(Iterable<com.bank.db.entity.Customer> customers) {
        List<com.bank.model.Customer> modelCustomers = new ArrayList<>();
        for (com.bank.db.entity.Customer customer : customers) {
            modelCustomers.add(convertToModel(customer));
        }
        return modelCustomers;
    }
    public static com.bank.model.Customer convertToModel(com.bank.db.entity.Customer customer) {
        com.bank.model.Customer modelCustomer = new com.bank.model.Customer();
        modelCustomer.setId(customer.getId());
        modelCustomer.setName(customer.getName());
        modelCustomer.setAddress(customer.getAddress());
        modelCustomer.setPhone(customer.getPhone());
        modelCustomer.setEmail(customer.getEmail());
        modelCustomer.setDob(customer.getDob());
        return modelCustomer;
    }

}

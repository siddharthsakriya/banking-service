package com.bank.controller;

import com.bank.model.Customer;
import com.bank.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class CustomerControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;
    @Test
    void getCustomers() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List testList = new ArrayList<>();
        testList.add(new Customer(0, "John", "Smith", "0101010","828282",LocalDate.parse("1999-01-08")));
        testList.add(new Customer(1, "Jane", "Doe", "0202020","929292",LocalDate.parse("1999-01-08")));
        String expectedResult = objectMapper.writeValueAsString(testList);
        given(customerService.getCustomers()).willReturn(testList);
        ResultActions response = mockMvc.perform(get("/api/v1/customer/getcustomers"));
        assertEquals(response.andReturn().getResponse().getContentAsString(), expectedResult);
    }
    @Test
    void getCustomerById() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        given(customerService.getCustomerById(0)).willReturn(new Customer(0, "John", "Smith", "0101010","828282",LocalDate.parse("1999-01-08")));
        ResultActions response = mockMvc.perform(get("/api/v1/customer/getcustomerbyid/0"));
        assertEquals(objectMapper.writeValueAsString(new Customer(0, "John", "Smith", "0101010","828282",LocalDate.parse("1999-01-08"))), response.andReturn().getResponse().getContentAsString());
    }

}

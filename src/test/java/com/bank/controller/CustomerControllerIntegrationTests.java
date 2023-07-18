package com.bank.controller;

import com.bank.service.AccountService;
import com.bank.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@WebMvcTest
public class CustomerControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;
    @MockBean
    private AccountService accountService;
    @Test
    void getEmptyCustomerList() throws Exception {
        when(customerService
                .getCustomers())
                .thenReturn(new ArrayList<>());
        mockMvc.perform(get("http://localhost:8080/api/v1/customer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}

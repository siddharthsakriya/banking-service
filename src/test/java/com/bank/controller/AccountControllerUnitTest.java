package com.bank.controller;

import com.bank.converter.AccountConverter;
import com.bank.model.Account;
import com.bank.service.AccountService;
import com.google.gson.Gson;
import com.google.protobuf.Any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class AccountControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountService accountService;
    @Test
    void getAccounts() throws Exception {
        List testList = new ArrayList<>();
        testList.add(new Account(0, 0, 292.0, "GBP"));
        testList.add(new Account(1, 1, 111.0, "GBP"));
        Gson gson = new Gson();
        String expectedResult = gson.toJson(testList);
        given(accountService.getAccounts()).willReturn(List.of(
                new Account(0, 0, 292.0, "GBP"),
                new Account(1, 1, 111.0, "GBP")));
        ResultActions response = mockMvc.perform(get("/api/v1/account/getaccounts"));
        assertEquals(response.andReturn().getResponse().getContentAsString(), expectedResult);
    }

    @Test
    void getAccountById() throws Exception{
        Gson gson = new Gson();
        given(accountService.getAccountById(0)).willReturn(new Account(0, 0, 292.0, "GBP"));
        ResultActions response = mockMvc.perform(get("/api/v1/account/getaccount/0"));
        assertEquals(response.andReturn().getResponse().getContentAsString(), gson.toJson(new Account(0, 0, 292.0, "GBP")));
    }

    @Test
    void addAccount() throws Exception {
        Account testAccount = new Account(2, 2, 222.0, "GBP");
        Gson gson = new Gson();
        given(accountService.addAccount(any(Account.class))).willReturn(testAccount.getAccountID());
        ResultActions response = mockMvc.perform(post("/api/v1/account/addaccount")
                .contentType("application/json")
                .content(gson.toJson(testAccount)));
        String result = response.andReturn().getResponse().getContentAsString();
        assertEquals("2", result);
    }

    @Test
    void updateAccount() throws  Exception{
        Account testAccount = new Account(2, 2, 222.0, "GBP");
        Gson gson = new Gson();
        ResultActions response = mockMvc.perform(post("/api/v1/account/updateaccount")
                .contentType("application/json")
                .content(gson.toJson(testAccount)));
        assertEquals(response.andReturn().getResponse().getStatus(), 200);
    }

    @Test
    void deleteAccount() throws Exception{
        ResultActions response = mockMvc.perform(delete("/api/v1/account/deleteaccount/0"));
        assertEquals(response.andReturn().getResponse().getStatus(), 200);
    }
}
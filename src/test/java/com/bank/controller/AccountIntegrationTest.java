package com.bank.controller;
import com.bank.BankingServiceApplication;
import com.bank.db.repository.AccountRepository;
import com.bank.model.Account;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest(classes = BankingServiceApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
// random port used to avoid port conflicts
public class AccountIntegrationTest {
    @Autowired
    AccountRepository accountRepository;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate rest;
    private String url;
    // set up the url before each test as the port varies
    @BeforeEach
    public void setup() {
        url = "http://localhost:" + port;
    }
    @Test
    public void testGetAccounts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Account>> response = rest.exchange(url + "/api/v1/account/getaccounts",
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Account>>(){});
        assertNotNull(response.getBody());
        //200 is the http status code for OK
        assertEquals(200, response.getStatusCodeValue());
    }
    @Test
    public void  testGetAccountsByID(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Account> response = rest.exchange(url + "/api/v1/account/getaccount/1",
                HttpMethod.GET, entity, new ParameterizedTypeReference<Account>(){});
        assertNotNull(response.getBody());
        //200 is the http status code for OK
        assertEquals(200, response.getStatusCodeValue());
    }
    @Test
    public void testAddAccounts(){
        Account account = new Account (266, 222.0, "GBP");
        Gson gson = new Gson();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(gson.toJson(account), headers);
        ResponseEntity<Integer> response = rest.exchange(url + "/api/v1/account/addaccount",
                HttpMethod.POST, entity, new ParameterizedTypeReference<Integer>(){});
        Integer result = response.getBody();
        assertEquals(2, result);
        assertNotNull(result);
        assertEquals(200, response.getStatusCodeValue());
    }
    @Test
    public void testDeleteAccounts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        rest.exchange(url + "/api/v1/account/deleteaccount/1",
                HttpMethod.DELETE, entity, new ParameterizedTypeReference<Account>(){});
        HttpEntity<String> entity2 = new HttpEntity<>(headers);
        ResponseEntity<List<Account>> response2 = rest.exchange(url + "/api/v1/account/getaccounts",
                HttpMethod.GET, entity2, new ParameterizedTypeReference<List<Account>>(){});
        assertEquals( 0,response2.getBody().size());
    }

    @Test
    public void testUpdateAccounts(){
        Account account = new Account (1, 1, 222.0, "GBP");
        Gson gson = new Gson();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(gson.toJson(account), headers);
        ResponseEntity<Integer> response = rest.exchange(url + "/api/v1/account/updateaccount",
                HttpMethod.POST, entity, new ParameterizedTypeReference<Integer>(){});
        ResponseEntity<List<Account>> response2 = rest.exchange(url + "/api/v1/account/getaccounts",
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Account>>(){});
        String result = response2.getBody().get(0).getCurrency();
        assertNotNull(response2.getBody());
        assertEquals(1, response2.getBody().size());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("GBP", result);
    }
}

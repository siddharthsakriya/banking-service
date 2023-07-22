package com.bank.controller;

import com.bank.BankingServiceApplication;
import com.bank.model.Account;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = BankingServiceApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// random port used to avoid port conflicts
public class AccountIntegrationTest {

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
        ResponseEntity<List<Account>> response = rest.exchange(url + "/api/v1/account",
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Account>>(){});
        assertNotNull(response.getBody());
        //200 is the http status code for OK
        assertEquals(200, response.getStatusCodeValue());
    }

}

package com.bank.controller;

import com.bank.BankingServiceApplication;
import com.bank.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
public class CustomerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate rest;
    private String url;

    @BeforeEach
    public void setup(){
        url = "http://localhost:" + port;
    }

    @Test
    public void testGetCustomers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Customer>> response = rest.exchange(url + "/api/v1/customer",
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Customer>>(){});
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

}

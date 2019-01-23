package com.example.postgresdemo.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.postgresdemo.model.Pessoa;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PessoaTeste.class)
public class PessoaTeste
{
    
	@Test
	public void contextLoads() {
	}

    
}
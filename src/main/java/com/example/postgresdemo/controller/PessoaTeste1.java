package com.example.postgresdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.postgresdemo.model.Pessoa;

/*classe para testes*/
public class PessoaTeste1 extends PessoaTeste{


	private MockMvc mockMvc;
	
	@Autowired
	private PessoaController PessoaController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(PessoaController).build();
	}
	
	@Test /*GET */
	public void testeGET() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/pessoas")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test /*POST */
	public void testePost() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/pessoas")		
				.param("nome", "Bruno")
				.param("bairro", "jardim")
				.param("data_Nasc", "2014-12-29")
				.param("rua", "55")
				.param("cpf","46464")
				).andExpect(MockMvcResultMatchers.redirectedUrl("/pessoas"));
	}
}

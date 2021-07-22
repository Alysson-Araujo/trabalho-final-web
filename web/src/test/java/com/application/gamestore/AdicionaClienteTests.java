package com.application.gamestore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.application.drogaria.cliente.AdicionaClienteRequest;
import com.application.drogaria.cliente.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@Transactional
@ExtendWith(MockitoExtension.class)
class AdicionaClienteTests {
	private final String url = "http://localhost:8080";
	
	@Autowired
	MockMvc mock = null;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	public void clear() {
		clienteRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Adiciona cliente com sucesso")
	void adicionaClienteTest() throws Exception {
		AdicionaClienteRequest cliente = null;
		mock.perform(MockMvcRequestBuilders
				.post(url + "/cliente")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente)))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}

package br.com.doeparasuaparoquia.virtus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class APICidadeTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnCidadePeloId() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/cidades/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}

	
	@Test
	public void shouldReturnCidadesPeloEstado() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/cidades?estado=11"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
}

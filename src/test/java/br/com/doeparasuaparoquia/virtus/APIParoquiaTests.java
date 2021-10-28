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
public class APIParoquiaTests {
	
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnListaDeParoquias() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/paroquias?cidade=1&page=1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void shouldNotReturnDetalhesDaParoquia() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/paroquias/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

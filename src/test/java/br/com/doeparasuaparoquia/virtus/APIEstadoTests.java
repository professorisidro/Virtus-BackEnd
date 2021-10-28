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
public class APIEstadoTests {
	
	@Autowired
	private MockMvc mockMvc; // esse cara vai efetivamente chamar a API
	
	@Test
	public void shouldReturnListaDeEstados() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/estados"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void shouldReturnEstadoValido() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/estados/11"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void shouldNotReturnEstadoInvalido() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/estados/1"))
		.andExpect(MockMvcResultMatchers.status().is(404));
	}

}

package br.com.doeparasuaparoquia.virtus;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Estado;
import br.com.doeparasuaparoquia.virtus.services.ICidadeService;

@SpringBootTest
public class CidadeTests {
	
	@Autowired
	private ICidadeService cidadeService;	
	
	@Test
	public void shouldReturnCidadeByEstado() {
		Estado e = new Estado();
		e.setId(11);
		List<Cidade> lista = cidadeService.getCidadesByEstado(e);
	}
	
	@Test
	public void shouldReturnCidade() {
		Cidade c = cidadeService.getCidadeById(1);
		Assertions.assertNotEquals(c, null);
	}

}

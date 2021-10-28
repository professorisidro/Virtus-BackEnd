package br.com.doeparasuaparoquia.virtus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Paroquia;
import br.com.doeparasuaparoquia.virtus.services.IParoquiaService;

@RestController
@CrossOrigin("*")
public class ParoquiaController {
	
	@Autowired
	private IParoquiaService service;
	
	@GetMapping("/paroquias")
	public ResponseEntity<Page<Paroquia>> recuperarPelaCidade(@RequestParam(name="cidade") int cidade, @RequestParam(name="page", defaultValue = "0") int page){
		Cidade c = new Cidade();
		c.setId(cidade);
		return ResponseEntity.ok(service.getParoquiasPorCidade(c, page));
	}
	
	@GetMapping("/paroquias/{id}")
	public ResponseEntity<Paroquia> recupearPeloId(@PathVariable int id){
		Paroquia p = service.getParoquiaPeloId(id);
		if (p != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.notFound().build();
	}

}

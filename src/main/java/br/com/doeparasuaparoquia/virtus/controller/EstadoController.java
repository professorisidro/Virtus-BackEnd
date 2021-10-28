package br.com.doeparasuaparoquia.virtus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.doeparasuaparoquia.virtus.model.Estado;
import br.com.doeparasuaparoquia.virtus.services.IEstadoService;

@RestController
@CrossOrigin("*")
public class EstadoController {
	
	@Autowired
	private IEstadoService estadoService;
	
	@GetMapping("/estados")
	public ResponseEntity<List<Estado>> recuperarTodos(){
		return ResponseEntity.ok(estadoService.getAllEstados());
	}
	
	@GetMapping("/estados/{id}")
	public ResponseEntity<Estado> recuperarPeloId(@PathVariable int id){
		Estado e = estadoService.getEstadoById(id);
		if (e != null) {
			return ResponseEntity.ok(e);
		}
		return ResponseEntity.notFound().build();
	}
}

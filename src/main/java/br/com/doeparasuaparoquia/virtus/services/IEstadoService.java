package br.com.doeparasuaparoquia.virtus.services;

import java.util.List;

import br.com.doeparasuaparoquia.virtus.model.Estado;

public interface IEstadoService {
	public Estado getEstadoById(int id);

	public List<Estado> getAllEstados();

}

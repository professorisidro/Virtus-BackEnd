package br.com.doeparasuaparoquia.virtus.services;

import java.util.List;

import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Estado;

public interface ICidadeService {
	public List<Cidade> getCidadesByEstado(Estado e);

	public Cidade getCidadeById(int id);

}

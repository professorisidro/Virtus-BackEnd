package br.com.doeparasuaparoquia.virtus.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Estado;

public interface CidadeDAO extends CrudRepository<Cidade, Integer>{
	public List<Cidade> findAllByEstado(Estado e);

}

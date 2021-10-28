package br.com.doeparasuaparoquia.virtus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.doeparasuaparoquia.virtus.dao.CidadeDAO;
import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Estado;

@Component
public class CidadeServiceImpl implements ICidadeService{

	@Autowired 
	private CidadeDAO dao;
	
	@Override
	public List<Cidade> getCidadesByEstado(Estado e) {
		// TODO Auto-generated method stub
		return dao.findAllByEstado(e);
	}

	@Override
	public Cidade getCidadeById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
}

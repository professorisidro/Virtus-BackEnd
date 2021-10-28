package br.com.doeparasuaparoquia.virtus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.doeparasuaparoquia.virtus.dao.EstadoDAO;
import br.com.doeparasuaparoquia.virtus.model.Estado;

@Component
public class EstadoServiceImpl implements IEstadoService {

	@Autowired 
	private EstadoDAO dao;
	@Override
	public Estado getEstadoById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
	@Override
	public List<Estado> getAllEstados() {
		// TODO Auto-generated method stub
		return (List<Estado>)dao.findAll();
	}
}

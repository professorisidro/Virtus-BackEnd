package br.com.doeparasuaparoquia.virtus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.doeparasuaparoquia.virtus.dao.ParoquiaDAO;
import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Paroquia;

@Component
public class ParoquiaServiceImpl implements IParoquiaService{

	@Autowired
	private ParoquiaDAO dao;
	@Override
	public Page<Paroquia> getParoquiasPorCidade(Cidade c, int pagina) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pagina, 10);
		return dao.findAllByCidade(c, pageable);
	}
	@Override
	public Paroquia getParoquiaPeloId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
	@Override
	public Paroquia adicionarParoquia(Paroquia novaParoquia) {
		// TODO Auto-generated method stub
		return dao.save(novaParoquia);
	}
	@Override
	public Paroquia atualizarParoquia(Paroquia paroquia) {
		// TODO Auto-generated method stub
		return dao.save(paroquia);
	}
	

}

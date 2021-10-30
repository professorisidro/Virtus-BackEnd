package br.com.doeparasuaparoquia.virtus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.doeparasuaparoquia.virtus.dao.UsuarioDAO;
import br.com.doeparasuaparoquia.virtus.model.Usuario;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

	
	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public Usuario recupearPeloLoginOuEmail(String login, String email) {
		// TODO Auto-generated method stub
		Usuario res =  dao.findByLoginOrEmail(login, email);
		return res;
	}
	

}

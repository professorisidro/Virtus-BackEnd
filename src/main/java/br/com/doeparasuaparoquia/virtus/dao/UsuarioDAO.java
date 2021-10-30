package br.com.doeparasuaparoquia.virtus.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.doeparasuaparoquia.virtus.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByLoginOrEmail(String login, String email);

}

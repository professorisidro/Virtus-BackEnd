package br.com.doeparasuaparoquia.virtus.services;

import br.com.doeparasuaparoquia.virtus.model.Usuario;

public interface IUsuarioService {
	public Usuario recupearPeloLoginOuEmail(String login, String email) ;
}

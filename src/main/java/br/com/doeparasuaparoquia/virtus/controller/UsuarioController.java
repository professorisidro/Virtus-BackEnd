package br.com.doeparasuaparoquia.virtus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.doeparasuaparoquia.virtus.model.Usuario;
import br.com.doeparasuaparoquia.virtus.security.VirtusToken;
import br.com.doeparasuaparoquia.virtus.security.VirtusTokenUtil;
import br.com.doeparasuaparoquia.virtus.services.IUsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@PostMapping("/login")
	public ResponseEntity<VirtusToken> realizarLogin(@RequestBody Usuario dadosLogin) {
		Usuario res = service.recupearPeloLoginOuEmail(dadosLogin.getLogin(), dadosLogin.getEmail());		
		if (res != null) {
			if (res.getSenha().equals(dadosLogin.getSenha())) {
				VirtusToken virtusToken = new VirtusToken();
				virtusToken.setStrToken(VirtusTokenUtil.generateToken(res));
				
				System.out.println("Token GERADO "+virtusToken.getStrToken());
				
				return ResponseEntity.ok(virtusToken);
			}
		}
		return ResponseEntity.status(403).build();
	}

}

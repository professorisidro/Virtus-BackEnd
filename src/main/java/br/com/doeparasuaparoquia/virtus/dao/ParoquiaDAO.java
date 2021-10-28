package br.com.doeparasuaparoquia.virtus.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Paroquia;

public interface ParoquiaDAO extends JpaRepository<Paroquia, Integer> {

	public Page<Paroquia>findAllByCidade(Cidade c, Pageable page);
}

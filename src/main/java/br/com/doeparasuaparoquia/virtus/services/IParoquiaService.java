package br.com.doeparasuaparoquia.virtus.services;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.doeparasuaparoquia.virtus.model.Cidade;
import br.com.doeparasuaparoquia.virtus.model.Paroquia;

public interface IParoquiaService {

	public Page<Paroquia> getParoquiasPorCidade(Cidade c, int pagina);

	public Paroquia getParoquiaPeloId(int i);

}

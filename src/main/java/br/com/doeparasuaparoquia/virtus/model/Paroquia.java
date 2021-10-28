package br.com.doeparasuaparoquia.virtus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_paroquia")
public class Paroquia {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nome", length = 200, nullable= false)
	private String nome;
	@Column(name="paroco", length = 150, nullable = false)
	private String paroco;
	@Column(name="descricao")
	private String descricao;
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getParoco() {
		return paroco;
	}
	public void setParoco(String paroco) {
		this.paroco = paroco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}

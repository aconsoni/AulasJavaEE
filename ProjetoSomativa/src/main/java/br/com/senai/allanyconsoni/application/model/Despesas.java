package br.com.senai.allanyconsoni.application.model;

//IMPORTAÇÕES
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity //ENTIDADE
public class Despesas implements Serializable {

	@Id
	@GeneratedValue
	
	private Integer id;
	private String data;
	private double valor;
	private boolean edit;
	private String descricao;
	
	//MUITOS PARA MUITOS
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "despesas_produtos", //TABELA QUE JUNTA OS DOIS
			joinColumns = @JoinColumn(name = "despesas_id"),
			inverseJoinColumns = @JoinColumn(name = "produtos_idProduto"))
	private List<Produtos> produtos = new ArrayList<Produtos>();
		
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public boolean getEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}	
	
	public Despesas(String data, double valor, String descricao) {
		super();
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}
	public Despesas() {
	}
	
}

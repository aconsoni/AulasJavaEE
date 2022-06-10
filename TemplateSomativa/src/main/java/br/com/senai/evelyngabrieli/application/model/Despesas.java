package br.com.senai.evelyngabrieli.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;



@SuppressWarnings("serial")
@Entity //entidade
public class Despesas implements Serializable{

	@Id //id identificador para atributos da tabela
	@GeneratedValue 
	
	private Integer id;
	private String data;
	private String descricao;
	private Double valor;
	private boolean edit;
	
	@ManyToMany(fetch = FetchType.EAGER)     // muitos pra muitos
	@JoinTable(name = "despesas_produtos",      // uma tabela que junta os dois
		joinColumns = @JoinColumn(name = "despesas_id"),
		inverseJoinColumns = @JoinColumn(name = "produtos_idProduto")) 
	private List<Produtos> produtos = new ArrayList<Produtos>();
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public Despesas(String data, String descricao, Double valor) {//com parametros
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Despesas() { //vazio
		super();
	}
	
	
}
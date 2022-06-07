package br.com.senai.allanyconsoni.application.bean;

//IMPORTAÇÕES
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.senai.allanyconsoni.jpa.ejbbean.DespesasBean;
import br.com.senai.allanyconsoni.application.model.Despesas;
import br.com.senai.allanyconsoni.application.model.Produtos;

@SuppressWarnings("serial") //REMOVE AS SINALIZAÇÕES DE ADVERTENCIAS
@SessionScoped //MANTEM OS DADOS ENQUANTO O NAVEGADOR ESTIVER ABERTO (TEMPO DE VIDA DA PÁGINA)
@Named("tabela") //CHAMA A TABELA COM UM NOME MAIS FÁCIL

public class TabelaBean implements Serializable {
	
	@EJB
	private DespesasBean despesabean; 
	
	private Integer despesaID; 
	
	private List<Despesas> despesas = new ArrayList<>(); //LISTA PARA TRABALHAR COM O JSF
	
	String data;
	String descricao;
	Double valor;
	Boolean back = false;
	private List<Produtos> produtos;
	private Integer[] selectProdutosIds;
	
	@PostConstruct
	public void init() {
		produtos = ProdutoBean.listar();
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
	
	public Boolean getBack() {
		return back;
	}
	public void setBack(Boolean back) {
		this.back = back;
	}
	
	//CRIA UM NOVO OBJETO NA TABELA
	public String inserir(String data, String descricao, Double valor) {
		Despesas d = new Despesas(data, valor, descricao);
		d.setEdit(true);
		back = true;
		despesabean.inserir(d);
		despesas.add(d);
		data = null;
		descricao = null;
		valor = null;
		return null;
	}
	
	//EXCLUI UM OBJETO QUE JÁ EXISTE NA TABELA
	public void excluir(Despesas despesa) {
		despesabean.excluir(despesa);
		despesas = null;
	}
	
	//EDITA UM OBJETO QUE JÁ EXISTE NA TABELA
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		
		return null;
	}
	
	//GRAVA UM OBJETO NA TABELA
	public String gravar(Despesas despesa) { 
		despesa.setEdit(false);
		return null;
	}

	public List<Despesas> getDespesas(){
		if(despesas==null) {
			 List<Despesas> despesas = new ArrayList<>();
		}
		return despesas;
	}
	
	public List<Produtos> getProdutos(){
		return produtos;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectProdutosIds;
	}
}



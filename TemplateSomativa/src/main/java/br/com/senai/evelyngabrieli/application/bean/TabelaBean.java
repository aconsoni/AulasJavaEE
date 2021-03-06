package br.com.senai.evelyngabrieli.application.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.senai.evelyngabrieli.jpa.ejbbean.DespesasBean;
import br.com.senai.evelyngabrieli.jpa.ejbbean.ProdutoBean;

import br.com.senai.evelyngabrieli.application.model.Despesas;
import br.com.senai.evelyngabrieli.application.model.Produtos;
@SuppressWarnings("serial") //remove os anuncios de advertencia
@SessionScoped //tempo de vida da pagina. o "session" mantem dados enquanto o navegador estiver aberto
@Named("tabela") //para chamar a tabela com nome mais facil em outra pagina

public class TabelaBean implements Serializable{

	@EJB
	private DespesasBean despesabean; 
	
	@EJB
	private ProdutoBean produtobean;
	
	private Integer despesaID; 
	
	private List<Despesas> despesas = new ArrayList<>(); //lista que trabalha com o jsf, recebe a lista e grava na tabela
	
	String data;
	String descricao;
	Double valor;
	Boolean back = false;
	private List<Produtos> produtos;
	private Integer[] selectedProdutosIds;
	
	@PostConstruct //assim que carregou a pagina executa esse metodo
	public void init() {
		//mostra na tela todos os clientes e produtos cadastrados assim que iniciar
		produtos = produtobean.listar();
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
	
	//usado para criar um novo objeto na tabela
	public String inserir(String data, String descricao, Double valor) {
		Despesas d = new Despesas(data, descricao, valor); // Serve para acrescentar mais uma despesa na lista, na variavel d
		d.setEdit(true);
		back = true;
		despesabean.inserir(d);
		despesas.add(d);
		data = null;
		descricao = null;
		valor = null;
		return null;
	}
	
	//usado para excluir um objeto dentro da tabela
	public void excluir(Despesas despesa) {
		despesabean.excluir(despesa);
		despesas = null;
	}
	
	//usado para editar um objeto que ja existe dentro da tabela
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		
		return null;
	}
	
	//usado para gravar um objeto dentro tabela
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
	
	public List<Produtos> getProdutos() { // lista todos os produtos
		return produtos;
	}
	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}
	
	
}

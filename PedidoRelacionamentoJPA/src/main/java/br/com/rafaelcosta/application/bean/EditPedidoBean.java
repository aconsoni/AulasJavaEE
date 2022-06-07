package br.com.rafaelcosta.application.bean;

//

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.ClienteBean;
import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.ejb.ProdutoBean;
import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Produto;


@Named
@RequestScoped
public class EditPedidoBean implements Serializable {
	
	@EJB //GRAVA PEDIDO
	private PedidoBean pedidoBean; 
	
	@EJB //GRAVA PRODUTO
	private ProdutoBean produtoBean;
	
	@EJB //GRAVA CLIENTE
	private ClienteBean clienteBean;
	
	private List<Cliente> clientes; //LISTA TODOS OS CLIENTE
	private List<Produto> produtos; //LISTA TODOS OS PRODUTOS
	
	private Integer selectedClienteId;     //QUAL O ID DO CLIENTE
	private Integer[] selectedProdutosIds; //LISTA QUE CARREGA OS PRODUTOS NA TELA
	
	@PostConstruct //ASSIM QUE CONTRUIU A PAGINA, CARREGA O MÉTODO
	public void init() {
		clientes = clienteBean.listar(); //PREENCHE COM CLIENTES
		produtos = produtoBean.listar(); //PREENCHE COM PRODUTOS
	}
	
	public String cadastrarPedido() throws Exception { 
		pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds); //PEGA O ID DO CLIENTE E O ID DO PRODUTO
		return "pedidos?faces-redirect=true"; //APAGA DEPOIS QUE CADASTRA
	}
	
	public List<Cliente> getClientes() { //GET DO LIST
		return clientes;
	}

	public List<Produto> getProdutos() { //GET DE PRODUTOS
		return produtos;
	}

	public Integer getSelectedClienteId() { //PREENCHE O SELECT_CLIENTE
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) { 
		this.selectedClienteId = selectedClienteId;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) { 
		this.selectedProdutosIds = selectedProdutosIds;
	}
}
package br.com.rafaelcosta.application.bean;

//LISTA TODOS OS PEDIDOS

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.model.Pedido;


@Named
@RequestScoped
public class ListPedidosBean implements Serializable {

	@EJB //LINKA COM O 
	private PedidoBean pedidoBean;
	
	private List<Pedido> pedidos;
	
	@PostConstruct //CARA QUE CARREGA O PEDIDO 
	public void init() {
		pedidos = pedidoBean.listar();
	}

	
	//LISTA PEDIDOS
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	
	public String pagar(Integer pedidoId, String tipo) throws Exception  { //VAI RECEBER O NUMERO E O PEDIDO E MANDAR PARA O BEAN
		pedidoBean.pagar(pedidoId, tipo);
		return "pedidos?faces-redirect=true"; //APAGA AS INFORMAÇÕES DEPOIS DE CADASTRAR E SALVAR
	}
	
	
	public String excluir(Integer pedidoId) { 
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true"; 
	}
}

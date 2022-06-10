package br.com.rafaelcosta.application.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Pagamento;
import br.com.rafaelcosta.application.model.Pagamento.TipoPagamento;
import br.com.rafaelcosta.application.model.Pedido;
import br.com.rafaelcosta.application.model.Produto;


@Stateless
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> listar() { //LISTA TODOS OS PEDIDOS
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	public void pagar(Integer pedidoId, String tipo) { //RECEBE O ID E O TIPO DE PAGAMENTO
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId); //PESQUISA O TIPO DE PEDIDO PELO ID
		
		Pagamento pagamento = new Pagamento(); //VARIAVEL PARA PAGAMENTO
		pagamento.setTipoPagto(tipoPagamento); //SETA O TIPO DE PAGAMENTO
		em.persist(pagamento); //SALVA A INFORMAÇÃO NA TABEA
		
		pedido.setPagamento(pagamento); //GRAVA POIS É UM BIDEN
	}
	
	public void excluir(Integer pedidoId) { 
		Pedido pedido = em.find(Pedido.class, pedidoId); 
		em.remove(pedido); 
	}
	
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception { 
		Cliente cliente = em.find(Cliente.class, clienteId); //PROCURA O ID DO CLIENTE
		
		Pedido pedido = new Pedido(); //RECEBE PEDIDO
		pedido.setData(new Date()); //RECEBE DATA
		pedido.setCliente(cliente); //RECEBE CLIENTE
		em.persist(pedido); //GRAVA TODAS AS INFORMAÇÕES
		
		double valorTotal = 0; 
		for (Integer produtoId : produtosIds) { 
			Produto produto = em.find(Produto.class, produtoId);
			pedido.getProdutos().add(produto);
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal);
	}
}


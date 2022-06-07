package br.com.senai.allanyconsoni.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.allanyconsoni.application.model.Produtos;

@Stateless
public class ProdutoBean {
	
	@PersistenceContext //JPA QUE FAZ TUDO POR TRÁS, RESPONSAVEL PELA CONEXÃO COM O BANCO DE DADOS
	private EntityManager em;
	
	public List<Produtos> listar() {
		return em.createQuery("SELECT p FROM Produtos p", Produtos.class).getResultList();
	}

}

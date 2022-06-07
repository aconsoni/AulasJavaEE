package br.com.senai.allanyconsoni.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.allanyconsoni.application.model.Despesas;

@Stateless //TIPO DO BEAN
public class DespesasBean { 
	
	@PersistenceContext  //RESPOSAVEL PELA CONEXÃO COM O BANCO DE DADOS
	private EntityManager em; //CLASSE DO JPA QUE SE CONECTA COM O BANCO
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.remove(despesas); //REMOVE O QUE ESTÁ LÁ NA PÁGINA
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); //ATRAVÉS DO ID, TRÁS AS INFORMAÇÕES DA TABELA NOS CAMPOS PEQUENOS
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas); //FAZ UM UPDATE (ATUALIZAÇÃO DE ALGO QUE JÁ EXISTE)
	}
	
	public void inserir(Despesas despesas) { //RECEBE A TAREFA
		em.persist(despesas); //INSERE E GRAVA
	}

}

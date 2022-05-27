package br.com.rafaelcosta.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless   //TIPO DE BEAN
public class TarefaBean {  //LOGÍSTICA DE NEGÓCIO

	@PersistenceContext  //CLASSE DO JPA QUE FAZ CONEXÃO COM O BANCO
	private EntityManager em; 
	
	public void inserir(Tarefa tarefa) { //RECEBE A TAREFA
		em.persist(tarefa);  
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa);  //ATUALIZA ALGO QUE JÁ EXISTE 
	}
	
	public void excluir(Tarefa tarefa) {   //EXCLUI A TAREFA
		tarefa = carregar(tarefa.getId());
		em.remove(tarefa);
	}
	
	public Tarefa carregar(int id) {
		return em.find(Tarefa.class, id); //O QUE VOCÊ ESTÁ PROCURANDO? ELE ACHA PELO ID
	}
}

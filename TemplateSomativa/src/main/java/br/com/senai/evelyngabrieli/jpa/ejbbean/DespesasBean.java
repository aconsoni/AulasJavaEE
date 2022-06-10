package br.com.senai.evelyngabrieli.jpa.ejbbean;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.evelyngabrieli.application.model.Despesas;

@Stateless // tipo de bean que é semelhante ao request
public class DespesasBean { //Logica de negocio
	
	@PersistenceContext  //vai ser responsavel por fazer a conexão com o banco de dados
	private EntityManager em; //classe da jpa que faz a conexão com o banco
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.remove(despesas); //remove o que esta la
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); //procura de acordo com o id, e tras as informações da tabela com os campos pequenos
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas);// merge faz um update, atualizar algo que ja existe
	}
	
	public void inserir(Despesas despesas) { //receber a tarefa
		em.persist(despesas);// aqui inseri, grava
	}
	 
	
	
}

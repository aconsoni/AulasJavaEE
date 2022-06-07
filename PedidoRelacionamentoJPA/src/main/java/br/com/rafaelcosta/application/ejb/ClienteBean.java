package br.com.rafaelcosta.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;


@Stateless //CONECTA COM A REQUISIÇÃO, TERMINOU, ELE DESCONECTA
public class ClienteBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Cliente> listar() { //RETORNA LISTA
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); //SELECIONA TODOS OS ITEM E GUARDA EM CLIENTE
	}
}

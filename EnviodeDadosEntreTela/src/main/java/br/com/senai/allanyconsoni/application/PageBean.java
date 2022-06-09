package br.com.senai.allanyconsoni.application;


//IMPORTAÇÕES
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped

public class PageBean implements Serializable {
	private String nome; //VARIAVEL
	
	@Inject //INJETA CÓDIGO
	private Flash flash;
	
	public String processar() { //PROCESSA A INFORMAÇÃO RECEBIDA
		flash.put("nomeDoUsuario", nome);
		return "Result?faces-redirect=true"; //REDIRECIONA PARA OUTRA PÁGINA
	}
	
	//GET'S E SET'S
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}

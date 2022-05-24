package br.com.senai.allanyconsoni.application.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("login")
@RequestScoped //

public class LoginBean implements Serializable{
	
	private String nome;
	private String senha;
	
	@PostConstruct //CHAMA ASSIM QUE FOR CONSTRUÍDO
	public void onCreate() {
		System.out.println("Bean criado");
	}
	
	@PreDestroy //CHAMA ASSIM QUE FOR DESTRUÍDO
	public void onDestroy() {
		System.out.println("Bean será destruído");
	}
	
	public String doLogin() {
		if("abc".equals(nome) && "123".equals(senha)) { //COMPARAÇÃO DE NOME E SENHA 
			return "page1Template"; //SE ESTIVER CERTO "SUCESSO" 
		}
		return null; //SE ESTIVER ERRADO VOLTA A PÁGINA DE LOGIN 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

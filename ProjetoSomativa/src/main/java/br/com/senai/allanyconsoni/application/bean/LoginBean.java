package br.com.senai.allanyconsoni.application.bean;

import java.io.Serializable; //IMPORTAÇÃO DO SERIALIZABLE

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("login")
@RequestScoped

public class LoginBean implements Serializable { //A IMPLEMENTAÇÃO DO SERIALIZABLE, MANDA TODA AS INFORMAÇÕES PARA A REDE
	
	//VARIAVEIS
	private String nome; 
	private String senha; 
	
	@PostConstruct	//É CHAMADO ASSIM QUE CONSTROI O BEAN
	public void onCreate() {
	 System.out.println("Bean criado");	
	}
	
	@PreDestroy //É CHAMADO ASSIM QUE DESTROI O BEAN
	public void onDestroy(){
	System.out.println("Bean será destruído");	
	}

	public String doLogin() { //SÓ DEIXA ENTRAR NA PÁGINA SE O USUÁRIO E SENHA FOREM VÁLIDOS
		if("abc".equals(nome) && "123".equals(senha)) {
			return "Page1";
		}
		return null; //FUNÇÃO QUE RETORNA A PÁGINA DE LOGIN CASO O LOGIN DO USUÁRIO DER ERRO
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



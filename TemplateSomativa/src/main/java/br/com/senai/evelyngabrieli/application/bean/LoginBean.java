package br.com.senai.evelyngabrieli.application.bean;

import java.io.Serializable; //importação serializable

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("login")
@RequestScoped 
public class LoginBean implements Serializable { // implementar o serializable para mandar todas as informações para a rede
	private String nome; //variaveis
	private String senha; //variaveis
	
	@PostConstruct	//chama assim que construir o bean
	public void onCreate() {
	 System.out.println("Bean criado");	
	}
	
	@PreDestroy // chama assim que destruir
	public void onDestroy(){
	System.out.println("Bean será destruído");	
	}

	public String doLogin() { //se o usuario e senha for igual ele vai deixar entrar na pagina
		if("abc".equals(nome) && "123".equals(senha)) {
			return "Page1";
		}
		return null; // se der erro vai voltar para a pagina de login
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

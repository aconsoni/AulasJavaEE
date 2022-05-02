package br.com.senai.allanyconsoni.application;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.allanyconsoni.model.Endereco;
import br.com.senai.allanyconsoni.model.Estado;
import br.com.senai.allanyconsoni.model.Interesse;
import br.com.senai.allanyconsoni.model.Pessoa;
import br.com.senai.allanyconsoni.model.Telefone;
import br.com.senai.allanyconsoni.util.InicializarConstantes;
@SuppressWarnings("serial")
@RequestScoped
@Named("cadastro")

public class CadBean implements Serializable{
	
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		
		}
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Estado> getEstados() {
		return InicializarConstantes.ESTADOS;
	}
	
	public List<Interesse> getInteresses() {
		return InicializarConstantes.INTERESSES;
	}
	
	

}

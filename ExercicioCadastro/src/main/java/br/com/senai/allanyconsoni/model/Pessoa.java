package br.com.senai.allanyconsoni.model;

import java.util.Date;

public class Pessoa {
		
	private String nome;
	private String emailString;
	private String datanasc;
	private Endereco enderecoResidencial;
	private Telefone telefoneResidencial;
	private String nomeEmpresa;
	private Endereco enderecoComercial;
	private Telefone telefoneCelular;
	private Telefone telefoneComercial;
	private String cargo;
	private Double salario;
	private Integer[] interesse;
	
	public Telefone getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(Telefone telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}
	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}
	public Telefone getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(Telefone telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}
	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}
	public Telefone getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(Telefone telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer[] getInteresse() {
		return interesse;
	}
	public void setInteresse(Integer[] interesse) {
		this.interesse = interesse;
	}
	
	
}

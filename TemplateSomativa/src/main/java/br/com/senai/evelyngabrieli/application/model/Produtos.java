package br.com.senai.evelyngabrieli.application.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//diz que é uma entidade que vai guardar no banco de dados, quando o java le ele cria a tabela
public class Produtos implements Serializable{

	@Id
	@GeneratedValue
	private Integer idProduto;
	private String nomeProduto;
	private double valorProduto;
	

	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	
}

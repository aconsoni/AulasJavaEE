package br.com.senai.allanyconsoni.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import br.com.senai.allanyconsoni.model.DesForm;
@SuppressWarnings("serial") //tira o aviso de cuidado do Eclipse
@SessionScoped //
@Named("tabela") //

public class FormBean implements Serializable{

	
	private List<DesForm> desform = new ArrayList<>();//recebe a lista chamada 'despesa' e grava na tabela
	
	//cria novo objeto dentro da tabela 
	public String inserir() {
		DesForm d = new DesForm();
		d.setEdit(true);
		desform.add(d);
		return null;
	}
	//revove a despesa dentro da tabela
	public String excluir(DesForm despesa) {
		desform.remove(despesa);
		return null;
	}
	//muda a forma que manipula a tabela
	public String editar(DesForm despesa) { 
		despesa.setEdit(true);
		return null;
	}
	//muda a forma que manipula a tabela
	public String gravar(DesForm despesa) { 
		despesa.setEdit(false);
		return null;
	}
	//mostra todas as depesas da tabela
	public List<DesForm> getDespesas(){
		return desform;
	}
	
}

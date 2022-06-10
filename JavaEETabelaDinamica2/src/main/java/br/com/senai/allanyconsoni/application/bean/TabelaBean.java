package br.com.senai.allanyconsoni.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import br.com.senai.allanyconsoni.model.Despesas;
@SuppressWarnings("serial") 
@SessionScoped //
@Named("tabela") //

public class TabelaBean implements Serializable{

	
	private List<Despesas> despesas = new ArrayList<>();
	
	//CRIA DESPESA
	public String inserir() {
		Despesas d = new Despesas();
		d.setEdit(true);
		despesas.add(d);
		return null;
	}
	//REMOVE DESPESA
	public String excluir(Despesas despesa) {
		despesas.remove(despesa);
		return null;
	}
	//EDITA DESPESA
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		return null;
	}
	//GRAVA DESPESA
	public String gravar(Despesas despesa) { 
		despesa.setEdit(false);
		return null;
	}
	//LISTA TODAS AS DESPESAS
	public List<Despesas> getDespesas(){
		return despesas;
	}
	
}

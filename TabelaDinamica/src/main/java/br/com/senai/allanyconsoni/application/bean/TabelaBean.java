package br.com.senai.allanyconsoni.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import br.com.senai.allanyconsoni.model.Despesas;
@SuppressWarnings("serial") 
@SessionScoped
@Named("tabela")

public class TabelaBean implements Serializable{

	
	private List<Despesas> despesasList = new ArrayList<>();//RECEBE A LISTA E GRAVA NA TABELA
	private ListDataModel<Despesas> despesas = new ListDataModel<>(despesasList);//CRIA LISTA NO JSF
	
	
	public String inserir() { //CRIA NOVO OBJETO
		Despesas d = new Despesas();
		d.setEdit(true);
		despesasList.add(d);
		return null;
	}
	
	public String excluir(Despesas despesa) { //REMOVE UM OBJETO DA LISTA
		despesasList.remove(despesa);
		return null;
	}
	
	public String editar(Despesas despesa) { //MUDA A FORMA DE MANIPULAR A TABELA
		despesa.setEdit(true);
		return null;
	}
	
	public String gravar(Despesas despesa) { //SE O 'EDITAR' FOR FALSO, APARECE APENAS O BOTÃO DE GRAVAR
		despesa.setEdit(false);
		return null;
	}
	
	public ListDataModel<Despesas> getDespesas(){ //CAPTURA AS DESPESAS
		return despesas;
	}
	
	
	

}

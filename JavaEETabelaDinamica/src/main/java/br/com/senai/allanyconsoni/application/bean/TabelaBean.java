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

	
	private List<Despesas> despesasList = new ArrayList<>();//RECEBE A LISTA E GRAVA NA TELA
	private ListDataModel<Despesas> despesas = new ListDataModel<>(despesasList);//CRIA LISTA NO JSF
	
	//CRIA UM OBJETO NOVO NA TABELA 
	public String inserir() {
		Despesas d = new Despesas();
		d.setEdit(true);
		despesasList.add(d);
		return null;
	}
	//EXCLUI UM OBJETO NA TABELA 
	public String excluir(Despesas despesa) {
		despesasList.remove(despesa);
		return null;
	}
	//MUDA A FORMA DE MANIPULAR A TABELA 
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		return null;
	}
	//MUDA A FORMA DE MANIPULAR A TABELA 
	public String gravar(Despesas despesa) { 
		despesa.setEdit(false);
		return null;
	}
	//MOSTRA A TABELA DE DESPESAS
	public ListDataModel<Despesas> getDespesas(){
		return despesas;
	}
	
	
	

}

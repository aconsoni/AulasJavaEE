package br.com.rafaelcosta.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.jpa.ejbbean.TarefaBean;
import br.com.rafaelcosta.jpa.model.Tarefa;

@Named("form") //
@RequestScoped //TEMPO DE VIDA, REQUISIÇÃO
public class FormBean implements Serializable {
	
	@EJB //CRIANDO UMA VARIAVEL QUE VAI RECEBER UMA TAREFA
	private TarefaBean tarefaBean;

	@Inject //PEGA TUDO OQ ACONTECE NO FORMULARIO, ERRO GRAVAÇÃO, 
	private FacesContext context;
	
	private UIComponent searchInputText; //DO EJB 
	
	private Integer tarefaId; //ATRIBUTO COMUM
	
	private Tarefa tarefa; //CLASSE QUE REPRESENTA UM OBJETO 
	
	public void gravar(AjaxBehaviorEvent event) {   //RECEBE UM EVENTO DE AJAX 
		if(tarefa.getId()==null) {                  //VÊ SE O ID EXISTE  
			tarefaBean.inserir(tarefa);             //INSERE TAREFA SE NÃO EXISTIR
		}else {
			tarefaBean.atualizar(tarefa);
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) {  //PESQUISA UM EVENTO DE AJAX 
		tarefa = tarefaBean.carregar(tarefaId);
		
		if(tarefa == null) {
			context.addMessage(searchInputText.getClientId(context),     //PEGA O INPUT TEXT, ADICIONA UMA MENSAGEM
					new FacesMessage("Tarefa n�o encontrada"));          //PEGA O TEXTO, ADICIONA UMA MENSAGEM
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) {    //EXCLUI UM EVENTO DE AJAX 
		tarefaBean.excluir(tarefa);                   //CHAMA A TAREFA E EXCLUI A QUE ESTÁ NA TELA 
		tarefa = null;                                //TELA VOLTA LIMPA
	}
	public Tarefa getTarefa() {                       //PROCURA A TAREFA
		if(tarefa==null) {                            //SE NÃO HOUVER TAREFA, ELA CRIA UMA NOVA
			tarefa = new Tarefa();                    
		}
		return tarefa; //SE A TELA NÃO EXISTIR 
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}

package br.com.rafaelcosta.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //FALA QUE ESSA TABELA É UMA ENTIDADE QUE VAI GRAVAR NO BANCO DE DADOS, A JPA LÊ E CRIA NA TABELA
public class Tarefa {  

	@Id //VIRA ENTIDADE NA TABELA
	@GeneratedValue //GERA O ID AUTOMATICAMENTE
	private Integer id;   
	
	private String descricao;    
	
	private Integer prioridade;
	
	private Boolean concluida;    //TRUE E FALSE

	public Integer getId() {  //GET
		return id;
	}

	public void setId(Integer id) {  //SET
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
}

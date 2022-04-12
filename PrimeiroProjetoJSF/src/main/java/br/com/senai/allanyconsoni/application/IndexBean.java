package br.com.senai.allanyconsoni.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class IndexBean implements Serializable {
	
	public String getMensagem() {
		return "Texto vindo do Bean";
	}

}

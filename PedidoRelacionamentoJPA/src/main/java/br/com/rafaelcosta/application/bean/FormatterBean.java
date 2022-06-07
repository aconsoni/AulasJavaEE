package br.com.rafaelcosta.application.bean;

//CLASSE QUE VAI FORMATAR A MOEDA
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped //FIXO
public class FormatterBean implements Serializable {

	private static final Locale LOCALE_BR = new Locale("pt", "BR"); //ENTREGA E LOCALIZA DE QUAL PAÍS (BRASIL)
	
	public String formatarMoeda(double valor) { //RECEBE O VALOR 
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR); //FORMATA O VALOR PARA REAIS
		return nf.format(valor); //RETORNA COM O 'R$'
	}
}

package br.com.senai.allanyconsoni.application.config;

import javax.enterprise.context.ApplicationScoped; 
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3) //VERSÃO DO JSF
@ApplicationScoped //ASSIM QUE A APLICAÇÃO CARREGAR, ELA VAI ESTAR CARREGADA E INSTANCIADA
public class Config { 
//CONFIGURAÇÃO DO JSF

}

package br.com.senai.evelyngabrieli.application.config;

import javax.enterprise.context.ApplicationScoped; 
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3) //versão do jsf
@ApplicationScoped //assim que aplicação carregar, ela vai estar carregada e instanciada 
public class Config { 
}//configuração para utilizar o jsf
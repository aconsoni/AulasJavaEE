package br.com.senai.allanyconsoni.application.confg;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped //QUANDO A APLICAÇÃO CARREGAR, ELE JÁ VAI ESTAR NA RIP CARREGADO E INSTANCIADO
public class Config {

}
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.ContrasenaPersona;
import model.ContrasenaPersonaDB;
import model.Persona;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanCambiarContrasena")
@SessionScoped
public class beanCambiarContrasena implements Serializable {

    int login;
    String password;
    
    ContrasenaPersona oContrasenaPersona;
    ContrasenaPersonaDB oContrasenaPersonaDB;
    Persona oPersona;
    Persona usuarioIngresado;
    
    
    /**
     * Creates a new instance of beanCambiarContrasena
     */
    public beanCambiarContrasena() {
    }
    
    public void getConsultarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        
        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	final Map<String, Object> session = context.getSessionMap();
	final Object user = session.get("Usuario");

	if (user != null) {
		try {
			Persona oUser = (Persona) user;
                        this.setoPersona(oUser);
                        this.setLogin(oUser.getCOD_PERSONA());
			
		} catch (ClassCastException e) {
			
			
		}
	}else{
		context.invalidateSession();
		
	}
	
	
        
        
        
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public Persona getUsuarioIngresado() {
        return usuarioIngresado;
    }

    public void setUsuarioIngresado(Persona usuarioIngresado) {
        this.usuarioIngresado = usuarioIngresado;
    }
    
}

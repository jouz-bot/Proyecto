/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Persona;
import model.PersonaDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanLoginControlador")
@SessionScoped
public class beanLoginControlador implements Serializable {
    String login;
    String password;
    Persona oPersona;
    Persona usuarioIngresado;
    
    /**
     * Creates a new instance of beanLoginControlador
     */
    public beanLoginControlador() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
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


    
     public void autenticar(){
         try {
             oPersona = new PersonaDB().loginPersona(this.login, this.password);

             if (oPersona != null) {
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", usuarioIngresado);
                 switch (oPersona.getCOD_ROL()) {
                     case 1:
                         FacesContext.getCurrentInstance().getExternalContext().redirect("inicioAdministrador.xhtml");
                         break;
                     case 2:
                         FacesContext.getCurrentInstance().getExternalContext().redirect("inicioInstructor.xhtml");
                         break;
                     default:
                         FacesContext.getCurrentInstance().getExternalContext().redirect("inicioDeportista.xhtml");
                        break;
                }

            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Usuario ó Clave incorrecta!"));
            }

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

    }
}

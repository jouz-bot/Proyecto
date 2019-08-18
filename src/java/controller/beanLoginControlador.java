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
    Persona usuarioIngresado;
    Persona oPersona = new Persona();
    String mensaje;

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

    public Persona getUsuarioIngresado() {
        return usuarioIngresado;
    }

    public void setUsuarioIngresado(Persona usuarioIngresado) {
        this.usuarioIngresado = usuarioIngresado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
    

       public void autenticar() {

        try {
            oPersona = new PersonaDB().loginPersona(this.getLogin(), this.getPassword());

            if (oPersona != null) {
                switch (oPersona.getCOD_ROL()) {
                    case 1:
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", oPersona);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("inicioAdministrador.xhtml");
                        break;
                    case 2:
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", oPersona);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("inicioInstructor.xhtml");
                        break;
                    default:
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", oPersona);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("inicioDeportista.xhtml");
                        break;
                }
            }

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

    }
    }

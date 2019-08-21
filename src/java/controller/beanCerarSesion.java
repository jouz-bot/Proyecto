/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanCerarSesion")
@SessionScoped
public class beanCerarSesion implements Serializable {

    /**
     * Creates a new instance of beanCerarSesion
     */
    public beanCerarSesion() {
    }
    
        public void cerrarSesion() {

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        context.invalidateSession();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.AsignacionDeportistaInstructor;
import model.AsignacionDeportistaInstructorDB;
import model.Persona;
import model.vistaDeportista;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanConsultarDeportistasAsignados")
@SessionScoped
public class beanConsultarDeportistasAsignados implements Serializable {

    int login = 0;
    Persona oPersona;
    Persona usuarioIngresado;
    AsignacionDeportistaInstructor oAsigDepor;
    vistaDeportista vista;

    LinkedList<vistaDeportista> listaDeportistas = new LinkedList<vistaDeportista>();
    /**
     * Creates a new instance of beanConsultarDeportistasAsignados
     */
    public beanConsultarDeportistasAsignados() throws SNMPExceptions, SQLException {
        getConsultarSesion();
        cargaTabla();
    }

    public void getConsultarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Object user = session.get("Usuario");

        if (user != null) {
            try {
                oPersona = (Persona) user;
                int id = oPersona.getCOD_PERSONA();
                this.setLogin(id);
//                Persona oUser = (Persona) user;
//                this.setoPersona(oUser);
//                this.setLogin(oUser.getCOD_PERSONA());

            } catch (ClassCastException e) {

            }
        } else {
            context.invalidateSession();
        }

    }

    public void cargaTabla() throws SNMPExceptions, SQLException {

        LinkedList<vistaDeportista> lista = new LinkedList<vistaDeportista>();
        AsignacionDeportistaInstructorDB  pDB = new AsignacionDeportistaInstructorDB();

        lista = pDB.tablaDeportistaAsignados(this.getLogin());

        this.setListaDeportistas(lista);

    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
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

    public LinkedList<vistaDeportista> getListaDeportistas() {
        return listaDeportistas;
    }

    public void setListaDeportistas(LinkedList<vistaDeportista> listaDeportistas) {
        this.listaDeportistas = listaDeportistas;
    }
    
    
}

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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import model.AsignacionDeportistaInstructor;
import model.AsignacionDeportistaInstructorDB;
import model.vistaDeportista;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanAsignacionDeportistaInstructor")
@SessionScoped
public class beanAsignacionDeportistaInstructor implements Serializable {

    //Asignacion de variables
    private int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    private int COD_PERSONA;
    private int COD_DEPORTISTA;
    private String mensaje;
    //para llenar una tabla
    LinkedList<vistaDeportista> listaTablaVistaDepo = new LinkedList<vistaDeportista>();
    LinkedList<vistaDeportista> listaTablaVistaInstru = new LinkedList<vistaDeportista>();
    LinkedList<vistaDeportista> listaFiltroTablaVistaInstru = new LinkedList<vistaDeportista>();
    
    private AsignacionDeportistaInstructor asignacionDeportistaInstructor;
    private AsignacionDeportistaInstructorDB asignacionDeportistaInstructorDB = new AsignacionDeportistaInstructorDB();

    /**
     * Creates a new instance of beanAsignacionDeportistaInstructor
     */
    public beanAsignacionDeportistaInstructor() {
    }
    
    public void guardarAsignacion(int codIns) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        AsignacionDeportistaInstructor vAsig = new AsignacionDeportistaInstructor();
        AsignacionDeportistaInstructorDB vDB = new AsignacionDeportistaInstructorDB();
        
        vAsig.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
        vAsig.setCOD_PERSONA(codIns);
        
        
        try {
            
            vDB.guardarDeportista(vAsig);
            this.setMensaje("Instructor asignado exitosamente!");
            
        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString() + "Error al guardar al Instructor"));
        }
        
    }

    //Metodos SET y GET
    public LinkedList<vistaDeportista> getListaTablaVistaDepo() throws SNMPExceptions, SQLException {
        LinkedList<vistaDeportista> lista = new LinkedList<vistaDeportista>();
        AsignacionDeportistaInstructorDB pDB = new AsignacionDeportistaInstructorDB();
        
        lista = pDB.tablaAsigDeportista();
        
        LinkedList resultLista = new LinkedList();
        
        resultLista = lista;
        return resultLista;
    }
    
    public LinkedList<vistaDeportista> getListaTablaVistaInstru() throws SNMPExceptions, SQLException {
        LinkedList<vistaDeportista> lista = new LinkedList<vistaDeportista>();
        AsignacionDeportistaInstructorDB pDB = new AsignacionDeportistaInstructorDB();
        
        lista = pDB.tablaAsigInstructor();
        
        LinkedList resultLista = new LinkedList();
        
        resultLista = lista;
        return resultLista;
    }
    
    public void ListaFiltroTablaVistaInstr(String prov, String can, String dis, int codDepo) throws SNMPExceptions, SQLException {
//           LinkedList<vistaDeportista> lista = new LinkedList<vistaDeportista>();
        AsignacionDeportistaInstructorDB pDB = new AsignacionDeportistaInstructorDB();

//        lista = pDB.tablaFiltroAsigInstructor(prov, can);
        this.setCOD_DEPORTISTA(codDepo);
        
        this.setListaFiltroTablaVistaInstru(pDB.tablaFiltroAsigInstructor(prov, can, dis));
//        this.listaFiltroTablaVistaInstru=lista;
//
//        LinkedList resultLista = new LinkedList();
//
//        resultLista = lista;
        
    }
    
    public LinkedList<vistaDeportista> getListaFiltroTablaVistaInstru() {
        return listaFiltroTablaVistaInstru;
    }
    
    public void setListaFiltroTablaVistaInstru(LinkedList<vistaDeportista> listaFiltroTablaVistaInstru) {
        this.listaFiltroTablaVistaInstru = listaFiltroTablaVistaInstru;
    }
    
    public void setListaTablaVistaDepo(LinkedList<vistaDeportista> listaTablaVistaDepo) {
        this.listaTablaVistaDepo = listaTablaVistaDepo;
    }
    
    public void setListaTablaVistaInstru(LinkedList<vistaDeportista> listaTablaVistaInstru) {
        this.listaTablaVistaInstru = listaTablaVistaInstru;
    }
    
    public int getCOD_ASIGNACION_DEPORTISTA_INSTRUCTOR() {
        return COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }
    
    public void setCOD_ASIGNACION_DEPORTISTA_INSTRUCTOR(int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR) {
        this.COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }
    
    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }
    
    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }
    
    public int getCOD_DEPORTISTA() {
        return COD_DEPORTISTA;
    }
    
    public void setCOD_DEPORTISTA(int COD_DEPORTISTA) {
        this.COD_DEPORTISTA = COD_DEPORTISTA;
    }
    
    public AsignacionDeportistaInstructor getAsignacionDeportistaInstructor() {
        return asignacionDeportistaInstructor;
    }
    
    public void setAsignacionDeportistaInstructor(AsignacionDeportistaInstructor asignacionDeportistaInstructor) {
        this.asignacionDeportistaInstructor = asignacionDeportistaInstructor;
    }
    
    public AsignacionDeportistaInstructorDB getAsignacionDeportistaInstructorDB() {
        return asignacionDeportistaInstructorDB;
    }
    
    public void setAsignacionDeportistaInstructorDB(AsignacionDeportistaInstructorDB asignacionDeportistaInstructorDB) {
        this.asignacionDeportistaInstructorDB = asignacionDeportistaInstructorDB;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}

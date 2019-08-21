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
import model.Correo;
import model.Persona;
import model.PersonaDB;
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
    private int COD_PERSONADeportista;
    private int COD_DEPORTISTA;
    private String mensaje;
    private String mensajeCorreo;
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
        //nota modificar y agregar cedulas en los 2 casos
        vAsig.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
        vAsig.setCOD_PERSONA(codIns);
        
        
        try {
            
            vDB.guardarDeportista(vAsig);
            this.enviarEmail(codIns, COD_PERSONADeportista);
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
    
    public void ListaFiltroTablaVistaInstr(String prov, String can, String dis, int codDepo, int codPersDepor) throws SNMPExceptions, SQLException {
//           LinkedList<vistaDeportista> lista = new LinkedList<vistaDeportista>();
        AsignacionDeportistaInstructorDB pDB = new AsignacionDeportistaInstructorDB();

//        lista = pDB.tablaFiltroAsigInstructor(prov, can);
        this.setCOD_DEPORTISTA(codDepo);
        this.setCOD_PERSONADeportista(codPersDepor);
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

    public int getCOD_PERSONADeportista() {
        return COD_PERSONADeportista;
    }

    public void setCOD_PERSONADeportista(int COD_PERSONADeportista) {
        this.COD_PERSONADeportista = COD_PERSONADeportista;
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

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }
    
    
    
            public void enviarEmail(int idInstructor, int idDeportista) {
        try {
            PersonaDB usuarioDB= new PersonaDB();
            //datos del deportista
            Persona PersonaDeportista = new Persona();
            PersonaDeportista=usuarioDB.buscarPersona(idDeportista);
            //datos del Instructor
            Persona personaInstructor = new Persona();
            personaInstructor=usuarioDB.buscarPersona(idInstructor);
            
            
            
            //Envio a Instructor
            String destino = personaInstructor.getDSC_CORREO();
            String asunto = "Asignación de Deportista";
            String mensajeCorr ="Estimado "+personaInstructor.getNOMBRE_PERSONA()+"!"+"\n\n" +
                    "Se le ha Asignado el deportista "+PersonaDeportista.getNOMBRE_PERSONA()+" "+ 
                    PersonaDeportista.getAPELLIDO1()+" "+PersonaDeportista.getAPELLIDO2();

            Correo objCorreo = new Correo();

            if (objCorreo.enviarMail(destino, asunto, mensajeCorr)) {
                
            this.setMensajeCorreo("El deportista e instructor fueron notificados");
            }else{
            
            this.setMensajeCorreo("Problema al enviar Correo");
            }
            
            
            
                String destinoDeportista = PersonaDeportista.getDSC_CORREO();
            String asuntoDeportista = "Asignación de Instructor";
            String mensajeCorreoDeportista = "Estimado "+PersonaDeportista.getNOMBRE_PERSONA()+"!"+"\n\n" +
                    "Se le ha Asignado el instructor "+personaInstructor.getNOMBRE_PERSONA()+" "+ 
                    personaInstructor.getAPELLIDO1()+" "+personaInstructor.getAPELLIDO2();

            Correo objCorreoDeportista = new Correo();

            if (objCorreoDeportista.enviarMail(destinoDeportista, asuntoDeportista, mensajeCorreoDeportista)) {
                
            this.setMensajeCorreo("El deportista e instructor fueron notificados");
            }else{
            
            this.setMensajeCorreo("Problema al enviar Correo");
            }
            


        } catch (Exception e) {
            this.setMensajeCorreo(e.getMessage());
        }
    }
    
}

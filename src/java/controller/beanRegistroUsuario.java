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
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import model.Barrio;
import model.BarrioDB;
import model.Cantones;
import model.CantonesDB;
import model.Deportista;
import model.DeportistaDB;
import model.Distritos;
import model.DistritosDB;
import model.Persona;
import model.PersonaDB;
import model.Provincias;
import model.ProvinciasDB;
import model.Telefono;
import model.TelefonoDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanRegistroUsuario")
@SessionScoped
public class beanRegistroUsuario implements Serializable {

    /**
     * Creates a new instance of beanRegistroUsuario
     */
    int COD_PERSONA;
    int COD_TIPO_IDENTIFICACION;
    String NOMBRE_PERSONA;
    String APELLIDO1;
    String APELLIDO2;
    float COD_PROVINCIA;
    float COD_CANTON;
    float COD_DISTRITO;
    float COD_BARRIO;
    String OTRAS_SENAS;
    String DSC_CORREO;
    String CONTRASENA;
    int COD_DISCIPLINA_DEPORTIVA;
    final int COD_DEPORTISTA = 0;
    final int COD_ROL = 2;
    double PESO;
    double TALLA;
    double ALTURA;
    String DSC_OBJETIVOS;

    String DSC_TELEFONO;

    String mensaje = "";

    public beanRegistroUsuario() {
    }

    public String getDSC_TELEFONO() {
        return DSC_TELEFONO;
    }

    public void setDSC_TELEFONO(String DSC_TELEFONO) {
        this.DSC_TELEFONO = DSC_TELEFONO;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public int getCOD_TIPO_IDENTIFICACION() {
        return COD_TIPO_IDENTIFICACION;
    }

    public void setCOD_TIPO_IDENTIFICACION(int COD_TIPO_IDENTIFICACION) {
        this.COD_TIPO_IDENTIFICACION = COD_TIPO_IDENTIFICACION;
    }

    public String getNOMBRE_PERSONA() {
        return NOMBRE_PERSONA;
    }

    public void setNOMBRE_PERSONA(String NOMBRE_PERSONA) {
        this.NOMBRE_PERSONA = NOMBRE_PERSONA;
    }

    public String getAPELLIDO1() {
        return APELLIDO1;
    }

    public void setAPELLIDO1(String APELLIDO1) {
        this.APELLIDO1 = APELLIDO1;
    }

    public String getAPELLIDO2() {
        return APELLIDO2;
    }

    public void setAPELLIDO2(String APELLIDO2) {
        this.APELLIDO2 = APELLIDO2;
    }

    public float getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(float COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public float getCOD_CANTON() {
        return COD_CANTON;
    }

    public void setCOD_CANTON(float COD_CANTON) {
        this.COD_CANTON = COD_CANTON;
    }

    public float getCOD_DISTRITO() {
        return COD_DISTRITO;
    }

    public void setCOD_DISTRITO(float COD_DISTRITO) {
        this.COD_DISTRITO = COD_DISTRITO;
    }

    public float getCOD_BARRIO() {
        return COD_BARRIO;
    }

    public void setCOD_BARRIO(float COD_BARRIO) {
        this.COD_BARRIO = COD_BARRIO;
    }

    public String getOTRAS_SENAS() {
        return OTRAS_SENAS;
    }

    public void setOTRAS_SENAS(String OTRAS_SENAS) {
        this.OTRAS_SENAS = OTRAS_SENAS;
    }

    public String getDSC_CORREO() {
        return DSC_CORREO;
    }

    public void setDSC_CORREO(String DSC_CORREO) {
        this.DSC_CORREO = DSC_CORREO;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }

    public int getCOD_DISCIPLINA_DEPORTIVA() {
        return COD_DISCIPLINA_DEPORTIVA;
    }

    public void setCOD_DISCIPLINA_DEPORTIVA(int COD_DISCIPLINA_DEPORTIVA) {
        this.COD_DISCIPLINA_DEPORTIVA = COD_DISCIPLINA_DEPORTIVA;
    }

    public int getCOD_DEPORTISTA() {
        return COD_DEPORTISTA;
    }

    public int getCOD_ROL() {
        return COD_ROL;
    }

    public String getMensaje() {
        return mensaje;
    }

    public double getPESO() {
        return PESO;
    }

    public void setPESO(double PESO) {
        this.PESO = PESO;
    }

    public double getTALLA() {
        return TALLA;
    }

    public void setTALLA(double TALLA) {
        this.TALLA = TALLA;
    }

    public double getALTURA() {
        return ALTURA;
    }

    public void setALTURA(double ALTURA) {
        this.ALTURA = ALTURA;
    }

    public String getDSC_OBJETIVOS() {
        return DSC_OBJETIVOS;
    }

    public void setDSC_OBJETIVOS(String DSC_OBJETIVOS) {
        this.DSC_OBJETIVOS = DSC_OBJETIVOS;
    }
    
    

    public void limpiarCampos() {
        this.setAPELLIDO1("");
        this.setAPELLIDO2("");
        this.setCOD_BARRIO(0);
        this.setCOD_CANTON(0);
        this.setCOD_DISCIPLINA_DEPORTIVA(0);
        this.setCOD_DISTRITO(0);
        this.setCOD_PERSONA(0);
        this.setCOD_PROVINCIA(0);
        this.setCOD_TIPO_IDENTIFICACION(0);
        this.setCONTRASENA("");
        this.setDSC_CORREO("");
        this.setMensaje("");
        this.setNOMBRE_PERSONA("");
        this.setOTRAS_SENAS("");
        this.limpiarTelefono();
        
    }
    
    public void limpiarCamposDepo() {
        this.setAPELLIDO1("");
        this.setAPELLIDO2("");
        this.setCOD_BARRIO(0);
        this.setCOD_CANTON(0);
        this.setCOD_DISCIPLINA_DEPORTIVA(0);
        this.setCOD_DISTRITO(0);
        this.setCOD_PERSONA(0);
        this.setCOD_PROVINCIA(0);
        this.setCOD_TIPO_IDENTIFICACION(0);
        this.setCONTRASENA("");
        this.setDSC_CORREO("");
        this.setMensaje("");
        this.setNOMBRE_PERSONA("");
        this.setOTRAS_SENAS("");
      
        this.setALTURA(0);
        this.setTALLA(0);
        this.setPESO(0);
        this.setDSC_OBJETIVOS("");
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

//    Cargar provincias
    public LinkedList<SelectItem> getListaProvincia() throws SNMPExceptions, SQLException {
        float idProvincia;
        String nombreProvincia;

        LinkedList<Provincias> lista = new LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();

        try {
            lista = pDB.moTodo();
        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();
   //    resultList.add(new SelectItem(0, "Seleccione una Provincia"));

        for (Provincias pro : lista) {
            idProvincia = pro.getCod_provincia();
            nombreProvincia = pro.getDsc_provincia();
            resultList.add(new SelectItem(idProvincia, nombreProvincia));
        }
        return resultList;

    }
//    Cargar cantones

    public LinkedList<SelectItem> getListaCantonPorProvincia() throws SNMPExceptions, SQLException {
        float idCan;
        String nombreCan = "";

        LinkedList<Cantones> lista = new LinkedList<Cantones>();
        CantonesDB cDB = new CantonesDB();

        if (this.COD_PROVINCIA == 0) {
            return null;
        }
        try {
            lista = cDB.seleccionarCantonesPorProvincia(COD_PROVINCIA);
        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();
//        resultList.add(new SelectItem(0, "Seleccione un Canton"));

        for (Cantones pro : lista) {
            idCan = pro.getCOD_CANTON();
            nombreCan = pro.getDSC_CANTON();
            resultList.add(new SelectItem(idCan, nombreCan));
        }
        return resultList;

    }

//    Cargar distritos
    public LinkedList<SelectItem> getListaDistritoPorCanton() throws SNMPExceptions, SQLException {
        float idDistrito;
        String nombreDistrito = "";

        LinkedList<Distritos> lista = new LinkedList<Distritos>();
        DistritosDB dDB = new DistritosDB();

        if (this.COD_PROVINCIA == 0) {
            return null;
        }

        if (this.COD_CANTON == 0) {
            return null;
        }

        try {
            lista = dDB.seleccionarDistritoPorCanton(this.COD_PROVINCIA, this.COD_CANTON);

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();

        for (Distritos pro : lista) {
            idDistrito = pro.getCOD_DISTRITO();
            nombreDistrito = pro.getDSC_DISTRITO();
            resultList.add(new SelectItem(idDistrito, nombreDistrito));
        }
        return resultList;
    }

    //    Cargar barrio
    public LinkedList<SelectItem> getListaBarrioPorDistrito() throws SNMPExceptions, SQLException {
        float idBarrio;
        String nombreBarrio = "";

        LinkedList<Barrio> lista = new LinkedList<Barrio>();
        BarrioDB dDB = new BarrioDB();

        if (this.COD_PROVINCIA == 0) {
            return null;
        }

        if (this.COD_CANTON == 0) {
            return null;
        }

        if (this.COD_DISTRITO == 0) {
            return null;
        }

        try {
            lista = dDB.seleccionarBarrioPorDistrito(this.COD_PROVINCIA, this.COD_CANTON, this.COD_DISTRITO);

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();

        for (Barrio pro : lista) {
            idBarrio = pro.getCOD_BARRIO();
            nombreBarrio = pro.getDSC_BARRIO();
            resultList.add(new SelectItem(idBarrio, nombreBarrio));
        }
        return resultList;
    }
//    Guardar instructor

    public void guardarPersona() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        Persona vCan = new Persona();
        PersonaDB vDB = new PersonaDB();

        vCan.setCOD_PERSONA(this.getCOD_PERSONA());
        vCan.setCOD_TIPO_IDENTIFICACION(this.getCOD_TIPO_IDENTIFICACION());
        vCan.setNOMBRE_PERSONA(this.getNOMBRE_PERSONA());
        vCan.setAPELLIDO1(this.getAPELLIDO1());
        vCan.setAPELLIDO2(this.getAPELLIDO2());
        vCan.setCOD_PROVINCIA(this.getCOD_PROVINCIA());
        vCan.setCOD_CANTON(this.getCOD_CANTON());
        vCan.setCOD_DISTRITO(this.getCOD_DISTRITO());
        vCan.setCOD_BARRIO(this.getCOD_BARRIO());
        vCan.setOTRAS_SENAS(this.getOTRAS_SENAS());
        vCan.setDSC_CORREO(this.getDSC_CORREO());
        vCan.setCONTRASENA(this.getCONTRASENA());
        vCan.setCOD_DISCIPLINA_DEPORTIVA(this.getCOD_DISCIPLINA_DEPORTIVA());
        vCan.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
        vCan.setCOD_ROL(this.getCOD_ROL());

        try {

            vDB.guardarPersona(vCan);
            this.setMensaje("Instructor guardado exitosamente!");

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString() + "Error al guardar al Instructor"));
        }

    }

    //    Guardar instructor
    public void guardarDeportista() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        Persona vPersona = new Persona();
        PersonaDB vPersonaDB = new PersonaDB();
        Deportista vDeportista = new Deportista();
        DeportistaDB vDeportistaBD = new DeportistaDB();

        //datos persona
        vPersona.setCOD_PERSONA(this.getCOD_PERSONA());
        vPersona.setCOD_TIPO_IDENTIFICACION(this.getCOD_TIPO_IDENTIFICACION());
        vPersona.setNOMBRE_PERSONA(this.getNOMBRE_PERSONA());
        vPersona.setAPELLIDO1(this.getAPELLIDO1());
        vPersona.setAPELLIDO2(this.getAPELLIDO2());
        vPersona.setCOD_PROVINCIA(this.getCOD_PROVINCIA());
        vPersona.setCOD_CANTON(this.getCOD_CANTON());
        vPersona.setCOD_DISTRITO(this.getCOD_DISTRITO());
        vPersona.setCOD_BARRIO(this.getCOD_BARRIO());
        vPersona.setOTRAS_SENAS(this.getOTRAS_SENAS());
        vPersona.setDSC_CORREO(this.getDSC_CORREO());
        vPersona.setCONTRASENA(this.getCONTRASENA());
        vPersona.setCOD_DISCIPLINA_DEPORTIVA(this.getCOD_DISCIPLINA_DEPORTIVA());
        vPersona.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
        vPersona.setCOD_ROL(this.getCOD_ROL());

        //datos dportista
        vDeportista.setCOD_PERSONA(vPersona.getCOD_PERSONA());
        vDeportista.setPESO(this.getPESO());
        vDeportista.setTALLA(this.getTALLA());
        vDeportista.setALTURA(this.getALTURA());
        vDeportista.setDSC_OBJETIVOS(this.getDSC_OBJETIVOS());

        try {

            vDeportistaBD.guardarDeportista(vPersona, vDeportista);
            this.limpiarCamposDepo();
            this.setMensaje("Deportista guardado exitosamente!");

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString() + "Error al guardar al Instructor"));
        }

    }

//    Guardar telefono
    public void guardarTelefono() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        if (this.COD_PERSONA == 0) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", "Debe de ingresar el numero de Instructor."));
        }

        if (this.DSC_TELEFONO.equals("")) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", "Debe de ingresar un numero de telefono"));
        }

        try {
            Telefono vCan = new Telefono();
            TelefonoDB vDB = new TelefonoDB();

            vCan.setDSC_TELEFONO(this.getDSC_TELEFONO());
            vCan.setCOD_PERSONA(this.getCOD_PERSONA());

            vDB.guardarVoto(vCan);
            this.limpiarTelefono();
            this.setMensaje("Telefono guardado exitosamente!");

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }
    }

//        Limpiar telefono
    public void limpiarTelefono() {
        this.setDSC_TELEFONO("");
    }
}

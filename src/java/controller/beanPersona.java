/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Deportista;
import model.DeportistaDB;
import model.Persona;
import model.PersonaDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanPersona")
@SessionScoped
public class beanPersona implements Serializable {
    //Lista de variables
    private int COD_PERSONA = 0;
    private int COD_TIPO_IDENTIFICACION = 0;
    private String NOMBRE_PERSONA;
    private String APELLIDO1;
    private String APELLIDO2;
    private int COD_PROVINCIA = 0;
    private int COD_CANTON = 0;
    private int COD_DISTRITO = 0;
    private int COD_BARRIO = 0;
    private int OTRAS_SENAS;
    private String DSC_CORREO;
    private String CONTRASENA;
    private int COD_DISCIPLINA_DEPORTIVA = 0;
    private int COD_DEPORTISTA = 0;
    
    private Persona persona;
    private PersonaDB personaDB = new PersonaDB();
    
    private double PESO = 0;
    private double TALLA = 0;
    private double ALTURA = 0;
    private String DSC_OBJETIVOS;
    
    private Deportista deportista;
    private DeportistaDB deportistaDB = new DeportistaDB();
    
    /**
     * Creates a new instance of beanPersona
     */
    public beanPersona() {
    }
    
    //Metodos SET y GET

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

    public int getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(int COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public int getCOD_CANTON() {
        return COD_CANTON;
    }

    public void setCOD_CANTON(int COD_CANTON) {
        this.COD_CANTON = COD_CANTON;
    }

    public int getCOD_DISTRITO() {
        return COD_DISTRITO;
    }

    public void setCOD_DISTRITO(int COD_DISTRITO) {
        this.COD_DISTRITO = COD_DISTRITO;
    }

    public int getCOD_BARRIO() {
        return COD_BARRIO;
    }

    public void setCOD_BARRIO(int COD_BARRIO) {
        this.COD_BARRIO = COD_BARRIO;
    }

    public int getOTRAS_SENAS() {
        return OTRAS_SENAS;
    }

    public void setOTRAS_SENAS(int OTRAS_SENAS) {
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

    public void setCOD_DEPORTISTA(int COD_DEPORTISTA) {
        this.COD_DEPORTISTA = COD_DEPORTISTA;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaDB getPersonaDB() {
        return personaDB;
    }

    public void setPersonaDB(PersonaDB personaDB) {
        this.personaDB = personaDB;
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

    public Deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }

    public DeportistaDB getDeportistaDB() {
        return deportistaDB;
    }

    public void setDeportistaDB(DeportistaDB deportistaDB) {
        this.deportistaDB = deportistaDB;
    }
    
}

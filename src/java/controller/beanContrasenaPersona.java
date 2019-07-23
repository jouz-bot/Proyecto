/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import model.ContrasenaPersona;
import model.ContrasenaPersonaDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanContrasenaPersona")
@SessionScoped
public class beanContrasenaPersona implements Serializable {
    //Definicion de variables
    private int COD_CONTRESANA = 0;
    private int COD_PERSONA = 0;
    private String DSC_CONTRESANA;
    private Date FECHA = new Date();
    private int ACTIVO = 0;
    
    private ContrasenaPersona contrasenaPersona;
    private ContrasenaPersonaDB contrasenaPersonaDB = new ContrasenaPersonaDB();
    
    /**
     * Creates a new instance of beanContrasenaPersona
     */
    public beanContrasenaPersona() {
    }
    
    //Metodos GET y SET

    public int getCOD_CONTRESANA() {
        return COD_CONTRESANA;
    }

    public void setCOD_CONTRESANA(int COD_CONTRESANA) {
        this.COD_CONTRESANA = COD_CONTRESANA;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public String getDSC_CONTRESANA() {
        return DSC_CONTRESANA;
    }

    public void setDSC_CONTRESANA(String DSC_CONTRESANA) {
        this.DSC_CONTRESANA = DSC_CONTRESANA;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public int getACTIVO() {
        return ACTIVO;
    }

    public void setACTIVO(int ACTIVO) {
        this.ACTIVO = ACTIVO;
    }

    public ContrasenaPersona getContrasenaPersona() {
        return contrasenaPersona;
    }

    public void setContrasenaPersona(ContrasenaPersona contrasenaPersona) {
        this.contrasenaPersona = contrasenaPersona;
    }

    public ContrasenaPersonaDB getContrasenaPersonaDB() {
        return contrasenaPersonaDB;
    }

    public void setContrasenaPersonaDB(ContrasenaPersonaDB contrasenaPersonaDB) {
        this.contrasenaPersonaDB = contrasenaPersonaDB;
    }
    
}

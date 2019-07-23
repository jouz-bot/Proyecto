/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.TelefonoDB;
import model.Telefono;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanTelefono")
@SessionScoped
public class beanTelefono implements Serializable {
    //Definicion de variables
    private int COD_TELEFONO = 0;
    private int DSC_TELEFONO;
    private int COD_PERSONA = 0;
    
    private Telefono telefono;
    private TelefonoDB telefonoDB = new TelefonoDB();
    
    /**
     * Creates a new instance of beanTelefono
     */
    public beanTelefono() {
    }
    
    //Metodos SET y GET

    public int getCOD_TELEFONO() {
        return COD_TELEFONO;
    }

    public void setCOD_TELEFONO(int COD_TELEFONO) {
        this.COD_TELEFONO = COD_TELEFONO;
    }

    public int getDSC_TELEFONO() {
        return DSC_TELEFONO;
    }

    public void setDSC_TELEFONO(int DSC_TELEFONO) {
        this.DSC_TELEFONO = DSC_TELEFONO;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public TelefonoDB getTelefonoDB() {
        return telefonoDB;
    }

    public void setTelefonoDB(TelefonoDB telefonoDB) {
        this.telefonoDB = telefonoDB;
    }
    
}

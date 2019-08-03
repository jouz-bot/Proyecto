/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jose_Cespedes
 */
public class Cantones {

    //Definicion de variables
    float COD_PROVINCIA;
    float COD_CANTON;
    String DSC_CANTON;
    float LOG_ACTIVO;

    //Metodo constructor

    public Cantones() {
    }

    public Cantones(float COD_PROVINCIA, float COD_CANTON, String DSC_CANTON, float LOG_ACTIVO) {
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.COD_CANTON = COD_CANTON;
        this.DSC_CANTON = DSC_CANTON;
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
    //Metodos SET y GET

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

    public String getDSC_CANTON() {
        return DSC_CANTON;
    }

    public void setDSC_CANTON(String DSC_CANTON) {
        this.DSC_CANTON = DSC_CANTON;
    }

    public float getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(float LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }

    
}

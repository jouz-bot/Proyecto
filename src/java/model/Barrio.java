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
public class Barrio {

    //Definicion de variables
    float COD_PROVINCIA;
    float COD_CANTON;
    float COD_DISTRITO;
    float COD_BARRIO;
    String DSC_BARRIO;
    float LOG_ACTIVO;
    
    //Metodo constructor

    public Barrio() {
    }

    public Barrio(float COD_PROVINCIA, float COD_CANTON, float COD_DISTRITO, float COD_BARRIO, String DSC_BARRIO, float LOG_ACTIVO) {
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.COD_CANTON = COD_CANTON;
        this.COD_DISTRITO = COD_DISTRITO;
        this.COD_BARRIO = COD_BARRIO;
        this.DSC_BARRIO = DSC_BARRIO;
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

    public String getDSC_BARRIO() {
        return DSC_BARRIO;
    }

    public void setDSC_BARRIO(String DSC_BARRIO) {
        this.DSC_BARRIO = DSC_BARRIO;
    }

    public float getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(float LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }

    
}

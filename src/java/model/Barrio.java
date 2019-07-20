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
    int COD_PROVINCIA;
    int COD_CANTON;
    int COD_DISTRITO;
    int COD_BARRIO;
    String DSC_BARRIO;
    int LOG_ACTIVO;
    
    //Metodo constructor

    public Barrio() {
    }

    public Barrio(int COD_PROVINCIA, int COD_CANTON, int COD_DISTRITO, int COD_BARRIO, String DSC_BARRIO, int LOG_ACTIVO) {
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.COD_CANTON = COD_CANTON;
        this.COD_DISTRITO = COD_DISTRITO;
        this.COD_BARRIO = COD_BARRIO;
        this.DSC_BARRIO = DSC_BARRIO;
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
    //Metodos SET y GET

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

    public String getDSC_BARRIO() {
        return DSC_BARRIO;
    }

    public void setDSC_BARRIO(String DSC_BARRIO) {
        this.DSC_BARRIO = DSC_BARRIO;
    }

    public int getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(int LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
}

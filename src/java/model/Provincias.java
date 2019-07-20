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
public class Provincias {

    //Definicion de variables
    int COD_PROVINCIA;
    String DSC_CORTA_PROVINCIA;
    String DSC_PROVINCIA;
    int LOG_ACTIVO;
    
    //Metodo constructor

    public Provincias() {
    }

    public Provincias(int COD_PROVINCIA, String DSC_CORTA_PROVINCIA, String DSC_PROVINCIA, int LOG_ACTIVO) {
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.DSC_CORTA_PROVINCIA = DSC_CORTA_PROVINCIA;
        this.DSC_PROVINCIA = DSC_PROVINCIA;
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
    
    //Metodos SET y GET

    public int getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(int COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public String getDSC_CORTA_PROVINCIA() {
        return DSC_CORTA_PROVINCIA;
    }

    public void setDSC_CORTA_PROVINCIA(String DSC_CORTA_PROVINCIA) {
        this.DSC_CORTA_PROVINCIA = DSC_CORTA_PROVINCIA;
    }

    public String getDSC_PROVINCIA() {
        return DSC_PROVINCIA;
    }

    public void setDSC_PROVINCIA(String DSC_PROVINCIA) {
        this.DSC_PROVINCIA = DSC_PROVINCIA;
    }

    public int getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(int LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
}

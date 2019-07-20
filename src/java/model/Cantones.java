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
    int COD_PROVINCIA;
    int COD_CANTON;
    String DSC_CANTON;
    int LOG_ACTIVO;

    //Metodo constructor

    public Cantones() {
    }

    public Cantones(int COD_PROVINCIA, int COD_CANTON, String DSC_CANTON, int LOG_ACTIVO) {
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.COD_CANTON = COD_CANTON;
        this.DSC_CANTON = DSC_CANTON;
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

    public String getDSC_CANTON() {
        return DSC_CANTON;
    }

    public void setDSC_CANTON(String DSC_CANTON) {
        this.DSC_CANTON = DSC_CANTON;
    }

    public int getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(int LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
}

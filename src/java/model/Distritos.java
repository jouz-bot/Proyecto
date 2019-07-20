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
public class Distritos {

    //Definision de variables
    int COD_PROVINCIA;
    int COD_CANTON;
    int COD_DISTRITO;
    String DSC_DISTRITO;
    int LOG_ACTIVO;

    //Metodo constructor

    public Distritos() {
    }

    public Distritos(int COD_PROVINCIA, int COD_CANTON, int COD_DISTRITO, String DSC_DISTRITO, int LOG_ACTIVO) {
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.COD_CANTON = COD_CANTON;
        this.COD_DISTRITO = COD_DISTRITO;
        this.DSC_DISTRITO = DSC_DISTRITO;
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

    public String getDSC_DISTRITO() {
        return DSC_DISTRITO;
    }

    public void setDSC_DISTRITO(String DSC_DISTRITO) {
        this.DSC_DISTRITO = DSC_DISTRITO;
    }

    public int getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(int LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }
    
}

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
public enum EnumActividadFisica {
    //Definicion de enums
    CORRER(1, "Correr"), SALTAR(2, "Saltar"), NADAR(3, "Nadar");

    //Definicion de variables
    public int COD_ACTIVIDAD_FISICA;
    public String DSC_ACTIVIDAD_FISICA;
    
    //Metodo constructor

    private EnumActividadFisica() {
    }

    private EnumActividadFisica(int COD_ACTIVIDAD_FISICA, String DSC_ACTIVIDAD_FISICA) {
        this.COD_ACTIVIDAD_FISICA = COD_ACTIVIDAD_FISICA;
        this.DSC_ACTIVIDAD_FISICA = DSC_ACTIVIDAD_FISICA;
    }
    
    //Metodos SET y GET

    public int getCOD_ACTIVIDAD_FISICA() {
        return COD_ACTIVIDAD_FISICA;
    }

    public void setCOD_ACTIVIDAD_FISICA(int COD_ACTIVIDAD_FISICA) {
        this.COD_ACTIVIDAD_FISICA = COD_ACTIVIDAD_FISICA;
    }

    public String getDSC_ACTIVIDAD_FISICA() {
        return DSC_ACTIVIDAD_FISICA;
    }

    public void setDSC_ACTIVIDAD_FISICA(String DSC_ACTIVIDAD_FISICA) {
        this.DSC_ACTIVIDAD_FISICA = DSC_ACTIVIDAD_FISICA;
    }
    
}

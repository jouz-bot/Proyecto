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
public enum EnumPeriocidad {
    
    //Definicion de Enums
    DIARIO(1, "Diario"), SEMANAL(2, "Semanal"), QUINCENAL(3, "Quincenal"), MENSUAL(4, "Mensual");
    
    //Definicion de atributos
    public int COD_PERIOCIDAD;
    public String DSC_PERIOCIDAD;
    
    //Metodo constructor

    private EnumPeriocidad() {
    }

    private EnumPeriocidad(int COD_PERIOCIDAD, String DSC_PERIOCIDAD) {
        this.COD_PERIOCIDAD = COD_PERIOCIDAD;
        this.DSC_PERIOCIDAD = DSC_PERIOCIDAD;
    }
    
    //Metodos SET y GET

    public int getCOD_PERIOCIDAD() {
        return COD_PERIOCIDAD;
    }

    public void setCOD_PERIOCIDAD(int COD_PERIOCIDAD) {
        this.COD_PERIOCIDAD = COD_PERIOCIDAD;
    }

    public String getDSC_PERIOCIDAD() {
        return DSC_PERIOCIDAD;
    }

    public void setDSC_PERIOCIDAD(String DSC_PERIOCIDAD) {
        this.DSC_PERIOCIDAD = DSC_PERIOCIDAD;
    }
    
}

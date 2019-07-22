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
public enum EnumTipoIdentificacion {

    //Definicion de Enums
    CEDULA(1, "Cedula"), PASAPORTE(2, "Pasaporte"), DIMEX(3, "Dimex");

    //Definicion de atributos
    public int COD_TIPO_IDENTIFICACION;
    public String DSC_TIPO_IDENTIFICACION;

    //Metodo constructor

    private EnumTipoIdentificacion() {
    }

    private EnumTipoIdentificacion(int COD_TIPO_IDENTIFICACION, String DSC_TIPO_IDENTIFICACION) {
        this.COD_TIPO_IDENTIFICACION = COD_TIPO_IDENTIFICACION;
        this.DSC_TIPO_IDENTIFICACION = DSC_TIPO_IDENTIFICACION;
    }
    
    //Metodos SET y GET

    public int getCOD_TIPO_IDENTIFICACION() {
        return COD_TIPO_IDENTIFICACION;
    }

    public void setCOD_TIPO_IDENTIFICACION(int COD_TIPO_IDENTIFICACION) {
        this.COD_TIPO_IDENTIFICACION = COD_TIPO_IDENTIFICACION;
    }

    public String getDSC_TIPO_IDENTIFICACION() {
        return DSC_TIPO_IDENTIFICACION;
    }

    public void setDSC_TIPO_IDENTIFICACION(String DSC_TIPO_IDENTIFICACION) {
        this.DSC_TIPO_IDENTIFICACION = DSC_TIPO_IDENTIFICACION;
    }
    
}

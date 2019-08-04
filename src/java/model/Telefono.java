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
public class Telefono {

    //Definicion de variables
    String DSC_TELEFONO;
    int COD_PERSONA ;

    //Metodo constructor
    public Telefono() {
    }

    public Telefono(String DSC_TELEFONO, int COD_PERSONA) {
        this.DSC_TELEFONO = DSC_TELEFONO;
        this.COD_PERSONA = COD_PERSONA;
    }
  
    //Metodos SET y GET

    public String getDSC_TELEFONO() {
        return DSC_TELEFONO;
    }

    public void setDSC_TELEFONO(String DSC_TELEFONO) {
        this.DSC_TELEFONO = DSC_TELEFONO;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    
}

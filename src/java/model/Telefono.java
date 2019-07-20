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
    private int COD_TELEFONO;
    private int DSC_TELEFONO;
    private int COD_PERSONA;

    //Metodo constructor

    public Telefono() {
    }

    public Telefono(int COD_TELEFONO, int DSC_TELEFONO, int COD_PERSONA) {
        this.COD_TELEFONO = COD_TELEFONO;
        this.DSC_TELEFONO = DSC_TELEFONO;
        this.COD_PERSONA = COD_PERSONA;
    }
    
    //Metodos SET y GET

    public int getCOD_TELEFONO() {
        return COD_TELEFONO;
    }

    public void setCOD_TELEFONO(int COD_TELEFONO) {
        this.COD_TELEFONO = COD_TELEFONO;
    }

    public int getDSC_TELEFONO() {
        return DSC_TELEFONO;
    }

    public void setDSC_TELEFONO(int DSC_TELEFONO) {
        this.DSC_TELEFONO = DSC_TELEFONO;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }
    
}

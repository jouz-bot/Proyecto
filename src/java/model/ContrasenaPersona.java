/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Jose_Cespedes
 */
public class ContrasenaPersona {

    //Definicion de variables
    private int COD_CONTRESANA;
    private int COD_PERSONA;
    private String DSC_CONTRESANA;
    private Date FECHA;
    private int ACTIVO;
    
    //Metodo constructor

    public ContrasenaPersona() {
    }

    public ContrasenaPersona(int COD_CONTRESANA, int COD_PERSONA, String DSC_CONTRESANA, Date FECHA, int ACTIVO) {
        this.COD_CONTRESANA = COD_CONTRESANA;
        this.COD_PERSONA = COD_PERSONA;
        this.DSC_CONTRESANA = DSC_CONTRESANA;
        this.FECHA = FECHA;
        this.ACTIVO = ACTIVO;
    }

    //Metodos SET y GET

    public int getCOD_CONTRESANA() {
        return COD_CONTRESANA;
    }

    public void setCOD_CONTRESANA(int COD_CONTRESANA) {
        this.COD_CONTRESANA = COD_CONTRESANA;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public String getDSC_CONTRESANA() {
        return DSC_CONTRESANA;
    }

    public void setDSC_CONTRESANA(String DSC_CONTRESANA) {
        this.DSC_CONTRESANA = DSC_CONTRESANA;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public int getACTIVO() {
        return ACTIVO;
    }

    public void setACTIVO(int ACTIVO) {
        this.ACTIVO = ACTIVO;
    }
    
}

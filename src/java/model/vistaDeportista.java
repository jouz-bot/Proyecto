/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ezeta
 */
public class vistaDeportista {
    
    private String NOMBRE_PERSONA;
    private String APELLIDO1;
    private int COD_DEPORTISTA;
    private int COD_PERSONA;
    private String DSC_DISPLINA_DEPORTIVA;
    private String DCS_PROVINCIA;
    private String DSC_CANTON;
    private String DSC_DISTRITO;

    public vistaDeportista(String NOMBRE_PERSONA, String APELLIDO1, int COD_DEPORTISTA, int COD_PERSONA, String DSC_DISPLINA_DEPORTIVA, String DCS_PROVINCIA, String DSC_CANTON, String DSC_DISTRITO) {
        this.NOMBRE_PERSONA = NOMBRE_PERSONA;
        this.APELLIDO1 = APELLIDO1;
        this.COD_DEPORTISTA = COD_DEPORTISTA;
        this.COD_PERSONA = COD_PERSONA;
        this.DSC_DISPLINA_DEPORTIVA = DSC_DISPLINA_DEPORTIVA;
        this.DCS_PROVINCIA = DCS_PROVINCIA;
        this.DSC_CANTON = DSC_CANTON;
        this.DSC_DISTRITO = DSC_DISTRITO;
    }

    public String getNOMBRE_PERSONA() {
        return NOMBRE_PERSONA;
    }

    public void setNOMBRE_PERSONA(String NOMBRE_PERSONA) {
        this.NOMBRE_PERSONA = NOMBRE_PERSONA;
    }

    public String getAPELLIDO1() {
        return APELLIDO1;
    }

    public void setAPELLIDO1(String APELLIDO1) {
        this.APELLIDO1 = APELLIDO1;
    }

    public int getCOD_DEPORTISTA() {
        return COD_DEPORTISTA;
    }

    public void setCOD_DEPORTISTA(int COD_DEPORTISTA) {
        this.COD_DEPORTISTA = COD_DEPORTISTA;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public String getDSC_DISPLINA_DEPORTIVA() {
        return DSC_DISPLINA_DEPORTIVA;
    }

    public void setDSC_DISPLINA_DEPORTIVA(String DSC_DISPLINA_DEPORTIVA) {
        this.DSC_DISPLINA_DEPORTIVA = DSC_DISPLINA_DEPORTIVA;
    }

    public String getDCS_PROVINCIA() {
        return DCS_PROVINCIA;
    }

    public void setDCS_PROVINCIA(String DCS_PROVINCIA) {
        this.DCS_PROVINCIA = DCS_PROVINCIA;
    }

    public String getDSC_CANTON() {
        return DSC_CANTON;
    }

    public void setDSC_CANTON(String DSC_CANTON) {
        this.DSC_CANTON = DSC_CANTON;
    }

    public String getDSC_DISTRITO() {
        return DSC_DISTRITO;
    }

    public void setDSC_DISTRITO(String DSC_DISTRITO) {
        this.DSC_DISTRITO = DSC_DISTRITO;
    }
    
    
    
    
    
    
}

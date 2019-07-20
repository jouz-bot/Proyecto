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
public class Deportista {

    //Lista de variables
    private int COD_DEPORTISTA;
    private int COD_PERSONA;
    private double PESO;
    private double TALLA;
    private double ALTURA;
    private String DSC_OBJETIVOS;

    //Metodo constructor

    public Deportista() {
    }

    public Deportista(int COD_DEPORTISTA, int COD_PERSONA, double PESO, double TALLA, double ALTURA, String DSC_OBJETIVOS) {
        this.COD_DEPORTISTA = COD_DEPORTISTA;
        this.COD_PERSONA = COD_PERSONA;
        this.PESO = PESO;
        this.TALLA = TALLA;
        this.ALTURA = ALTURA;
        this.DSC_OBJETIVOS = DSC_OBJETIVOS;
    }
    
    //Metodos GET y SET

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

    public double getPESO() {
        return PESO;
    }

    public void setPESO(double PESO) {
        this.PESO = PESO;
    }

    public double getTALLA() {
        return TALLA;
    }

    public void setTALLA(double TALLA) {
        this.TALLA = TALLA;
    }

    public double getALTURA() {
        return ALTURA;
    }

    public void setALTURA(double ALTURA) {
        this.ALTURA = ALTURA;
    }

    public String getDSC_OBJETIVOS() {
        return DSC_OBJETIVOS;
    }

    public void setDSC_OBJETIVOS(String DSC_OBJETIVOS) {
        this.DSC_OBJETIVOS = DSC_OBJETIVOS;
    }
    
}

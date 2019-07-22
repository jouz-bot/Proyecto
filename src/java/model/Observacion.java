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
public class Observacion {

    //Lista de variables
    private int COD_OBSERVACION;
    private int COD_PLAN_ENTRENAMIENTO;
    private String OBSERVACION;
    
    //Metodo constructor

    public Observacion() {
    }

    public Observacion(int COD_OBSERVACION, int COD_PLAN_ENTRENAMIENTO, String OBSERVACION) {
        this.COD_OBSERVACION = COD_OBSERVACION;
        this.COD_PLAN_ENTRENAMIENTO = COD_PLAN_ENTRENAMIENTO;
        this.OBSERVACION = OBSERVACION;
    }
    
    //Metodos GET y SET

    public int getCOD_OBSERVACION() {
        return COD_OBSERVACION;
    }

    public void setCOD_OBSERVACION(int COD_OBSERVACION) {
        this.COD_OBSERVACION = COD_OBSERVACION;
    }

    public int getCOD_PLAN_ENTRENAMIENTO() {
        return COD_PLAN_ENTRENAMIENTO;
    }

    public void setCOD_PLAN_ENTRENAMIENTO(int COD_PLAN_ENTRENAMIENTO) {
        this.COD_PLAN_ENTRENAMIENTO = COD_PLAN_ENTRENAMIENTO;
    }

    public String getOBSERVACION() {
        return OBSERVACION;
    }

    public void setOBSERVACION(String OBSERVACION) {
        this.OBSERVACION = OBSERVACION;
    }
    
}

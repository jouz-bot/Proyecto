/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Observacion;
import model.ObservacionDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanObservacion")
@SessionScoped
public class beanObservacion implements Serializable {
    //Lista de variables
    private int COD_OBSERVACION = 0;
    private int COD_PLAN_ENTRENAMIENTO = 0;
    private String OBSERVACION;
    
    private Observacion observacion;
    private ObservacionDB observacionDB = new ObservacionDB();
    
    /**
     * Creates a new instance of beanObservacion
     */
    public beanObservacion() {
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

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public ObservacionDB getObservacionDB() {
        return observacionDB;
    }

    public void setObservacionDB(ObservacionDB observacionDB) {
        this.observacionDB = observacionDB;
    }
    
}

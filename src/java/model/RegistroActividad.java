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
public class RegistroActividad {

    //Lista de variables
    private int COD_REGISTRO_ACTIVIDAD;
    private Date FECHA_REGISTRO;
    private Date FECHA_ACTIVIDAD;
    private String TIEMPO;
    private int REPETICIONES;
    private int COD_ACTIVIDAD_FISICA;
    private int COD_PLAN_ENTRENAMIENTO;
    
    //Metodo constructor

    public RegistroActividad() {
    }

    public RegistroActividad(int COD_REGISTRO_ACTIVIDAD, Date FECHA_REGISTRO, Date FECHA_ACTIVIDAD, String TIEMPO, int REPETICIONES, int COD_ACTIVIDAD_FISICA, int COD_PLAN_ENTRENAMIENTO) {
        this.COD_REGISTRO_ACTIVIDAD = COD_REGISTRO_ACTIVIDAD;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
        this.FECHA_ACTIVIDAD = FECHA_ACTIVIDAD;
        this.TIEMPO = TIEMPO;
        this.REPETICIONES = REPETICIONES;
        this.COD_ACTIVIDAD_FISICA = COD_ACTIVIDAD_FISICA;
        this.COD_PLAN_ENTRENAMIENTO = COD_PLAN_ENTRENAMIENTO;
    }
    
    //Metodos SET y GET

    public int getCOD_REGISTRO_ACTIVIDAD() {
        return COD_REGISTRO_ACTIVIDAD;
    }

    public void setCOD_REGISTRO_ACTIVIDAD(int COD_REGISTRO_ACTIVIDAD) {
        this.COD_REGISTRO_ACTIVIDAD = COD_REGISTRO_ACTIVIDAD;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Date getFECHA_ACTIVIDAD() {
        return FECHA_ACTIVIDAD;
    }

    public void setFECHA_ACTIVIDAD(Date FECHA_ACTIVIDAD) {
        this.FECHA_ACTIVIDAD = FECHA_ACTIVIDAD;
    }

    public String getTIEMPO() {
        return TIEMPO;
    }

    public void setTIEMPO(String TIEMPO) {
        this.TIEMPO = TIEMPO;
    }

    public int getREPETICIONES() {
        return REPETICIONES;
    }

    public void setREPETICIONES(int REPETICIONES) {
        this.REPETICIONES = REPETICIONES;
    }

    public int getCOD_ACTIVIDAD_FISICA() {
        return COD_ACTIVIDAD_FISICA;
    }

    public void setCOD_ACTIVIDAD_FISICA(int COD_ACTIVIDAD_FISICA) {
        this.COD_ACTIVIDAD_FISICA = COD_ACTIVIDAD_FISICA;
    }

    public int getCOD_PLAN_ENTRENAMIENTO() {
        return COD_PLAN_ENTRENAMIENTO;
    }

    public void setCOD_PLAN_ENTRENAMIENTO(int COD_PLAN_ENTRENAMIENTO) {
        this.COD_PLAN_ENTRENAMIENTO = COD_PLAN_ENTRENAMIENTO;
    }
    
}

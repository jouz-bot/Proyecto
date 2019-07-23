/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import model.RegistroActividad;
import model.RegistroActividadDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanRegistroActividad")
@SessionScoped
public class beanRegistroActividad implements Serializable {
    //Lista de variables
    private int COD_REGISTRO_ACTIVIDAD = 0;
    private Date FECHA_REGISTRO = new Date();
    private Date FECHA_ACTIVIDAD;
    private String TIEMPO;
    private int REPETICIONES = 0;
    private int COD_ACTIVIDAD_FISICA = 0;
    private int COD_PLAN_ENTRENAMIENTO = 0;
    
    private RegistroActividad registroActividad;
    private RegistroActividadDB registroActividadDB = new RegistroActividadDB();
    /**
     * Creates a new instance of beanRegistroActividad
     */
    public beanRegistroActividad() {
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

    public RegistroActividad getRegistroActividad() {
        return registroActividad;
    }

    public void setRegistroActividad(RegistroActividad registroActividad) {
        this.registroActividad = registroActividad;
    }

    public RegistroActividadDB getRegistroActividadDB() {
        return registroActividadDB;
    }

    public void setRegistroActividadDB(RegistroActividadDB registroActividadDB) {
        this.registroActividadDB = registroActividadDB;
    }
    
}

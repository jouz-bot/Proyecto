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
public class PlanEntrenamiento {

    //Lista de variables
    private int COD_PLAN_ENTRENAMIENTO;
    private int COD_PERIOCIDAD;
    private Date FECHA_INICIO;
    private Date FECHA_FIN;
    private int COD_ACTIVIDAD_FISICA;
    private String DSC_PLAN_ENTRENAMIENTO;
    private String DURACION;
    private int REPETICIONES;
    private int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;

    //Metodo constructor

    public PlanEntrenamiento() {
    }

    public PlanEntrenamiento(int COD_PLAN_ENTRENAMIENTO, int COD_PERIOCIDAD, Date FECHA_INICIO, Date FECHA_FIN, int COD_ACTIVIDAD_FISICA, String DSC_PLAN_ENTRENAMIENTO, String DURACION, int REPETICIONES, int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR) {
        this.COD_PLAN_ENTRENAMIENTO = COD_PLAN_ENTRENAMIENTO;
        this.COD_PERIOCIDAD = COD_PERIOCIDAD;
        this.FECHA_INICIO = FECHA_INICIO;
        this.FECHA_FIN = FECHA_FIN;
        this.COD_ACTIVIDAD_FISICA = COD_ACTIVIDAD_FISICA;
        this.DSC_PLAN_ENTRENAMIENTO = DSC_PLAN_ENTRENAMIENTO;
        this.DURACION = DURACION;
        this.REPETICIONES = REPETICIONES;
        this.COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }
    
    //Metodos SET y GET

    public int getCOD_PLAN_ENTRENAMIENTO() {
        return COD_PLAN_ENTRENAMIENTO;
    }

    public void setCOD_PLAN_ENTRENAMIENTO(int COD_PLAN_ENTRENAMIENTO) {
        this.COD_PLAN_ENTRENAMIENTO = COD_PLAN_ENTRENAMIENTO;
    }

    public int getCOD_PERIOCIDAD() {
        return COD_PERIOCIDAD;
    }

    public void setCOD_PERIOCIDAD(int COD_PERIOCIDAD) {
        this.COD_PERIOCIDAD = COD_PERIOCIDAD;
    }

    public Date getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public void setFECHA_INICIO(Date FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public Date getFECHA_FIN() {
        return FECHA_FIN;
    }

    public void setFECHA_FIN(Date FECHA_FIN) {
        this.FECHA_FIN = FECHA_FIN;
    }

    public int getCOD_ACTIVIDAD_FISICA() {
        return COD_ACTIVIDAD_FISICA;
    }

    public void setCOD_ACTIVIDAD_FISICA(int COD_ACTIVIDAD_FISICA) {
        this.COD_ACTIVIDAD_FISICA = COD_ACTIVIDAD_FISICA;
    }

    public String getDSC_PLAN_ENTRENAMIENTO() {
        return DSC_PLAN_ENTRENAMIENTO;
    }

    public void setDSC_PLAN_ENTRENAMIENTO(String DSC_PLAN_ENTRENAMIENTO) {
        this.DSC_PLAN_ENTRENAMIENTO = DSC_PLAN_ENTRENAMIENTO;
    }

    public String getDURACION() {
        return DURACION;
    }

    public void setDURACION(String DURACION) {
        this.DURACION = DURACION;
    }

    public int getREPETICIONES() {
        return REPETICIONES;
    }

    public void setREPETICIONES(int REPETICIONES) {
        this.REPETICIONES = REPETICIONES;
    }

    public int getCOD_ASIGNACION_DEPORTISTA_INSTRUCTOR() {
        return COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }

    public void setCOD_ASIGNACION_DEPORTISTA_INSTRUCTOR(int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR) {
        this.COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.AsignacionDeportistaInstructor;
import model.AsignacionDeportistaInstructorDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanAsignacionDeportistaInstructor")
@SessionScoped
public class beanAsignacionDeportistaInstructor implements Serializable {
    //Asignacion de variables
    private int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = 0;
    private int COD_PERSONA = 0;
    private int COD_DEPORTISTA = 0;
    
    private AsignacionDeportistaInstructor asignacionDeportistaInstructor;
    private AsignacionDeportistaInstructorDB asignacionDeportistaInstructorDB = new AsignacionDeportistaInstructorDB();
    
    /**
     * Creates a new instance of beanAsignacionDeportistaInstructor
     */
    public beanAsignacionDeportistaInstructor() {
    }
    
    //Metodos SET y GET

    public int getCOD_ASIGNACION_DEPORTISTA_INSTRUCTOR() {
        return COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }

    public void setCOD_ASIGNACION_DEPORTISTA_INSTRUCTOR(int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR) {
        this.COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    }

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public int getCOD_DEPORTISTA() {
        return COD_DEPORTISTA;
    }

    public void setCOD_DEPORTISTA(int COD_DEPORTISTA) {
        this.COD_DEPORTISTA = COD_DEPORTISTA;
    }

    public AsignacionDeportistaInstructor getAsignacionDeportistaInstructor() {
        return asignacionDeportistaInstructor;
    }

    public void setAsignacionDeportistaInstructor(AsignacionDeportistaInstructor asignacionDeportistaInstructor) {
        this.asignacionDeportistaInstructor = asignacionDeportistaInstructor;
    }

    public AsignacionDeportistaInstructorDB getAsignacionDeportistaInstructorDB() {
        return asignacionDeportistaInstructorDB;
    }

    public void setAsignacionDeportistaInstructorDB(AsignacionDeportistaInstructorDB asignacionDeportistaInstructorDB) {
        this.asignacionDeportistaInstructorDB = asignacionDeportistaInstructorDB;
    }
    
}

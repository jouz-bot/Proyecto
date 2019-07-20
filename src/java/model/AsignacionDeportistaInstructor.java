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
public class AsignacionDeportistaInstructor {

    //Asignacion de variables
    private int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
    private int COD_PERSONA;
    private int COD_DEPORTISTA;

    //Metodo constructor

    public AsignacionDeportistaInstructor() {
    }

    public AsignacionDeportistaInstructor(int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR, int COD_PERSONA, int COD_DEPORTISTA) {
        this.COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = COD_ASIGNACION_DEPORTISTA_INSTRUCTOR;
        this.COD_PERSONA = COD_PERSONA;
        this.COD_DEPORTISTA = COD_DEPORTISTA;
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
    
}

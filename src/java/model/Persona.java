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
public class Persona {

    //Lista de variables
    int COD_PERSONA;
    int COD_TIPO_IDENTIFICACION;
    String NOMBRE_PERSONA;
    String APELLIDO1;
    String APELLIDO2;
    float COD_PROVINCIA;
    float COD_CANTON;
    float COD_DISTRITO;
    float COD_BARRIO;
    String OTRAS_SENAS;
    String DSC_CORREO;
    String CONTRASENA;
    int COD_DISCIPLINA_DEPORTIVA;
    int COD_DEPORTISTA;
    int COD_ROL;

    //Metodo constructor
    public Persona() {
    }

    public Persona(int COD_PERSONA, int COD_TIPO_IDENTIFICACION, String NOMBRE_PERSONA, String APELLIDO1, String APELLIDO2, float COD_PROVINCIA, float COD_CANTON, float COD_DISTRITO, float COD_BARRIO, String OTRAS_SENAS, String DSC_CORREO, String CONTRASENA, int COD_DISCIPLINA_DEPORTIVA, int COD_DEPORTISTA, int COD_ROL) {
        this.COD_PERSONA = COD_PERSONA;
        this.COD_TIPO_IDENTIFICACION = COD_TIPO_IDENTIFICACION;
        this.NOMBRE_PERSONA = NOMBRE_PERSONA;
        this.APELLIDO1 = APELLIDO1;
        this.APELLIDO2 = APELLIDO2;
        this.COD_PROVINCIA = COD_PROVINCIA;
        this.COD_CANTON = COD_CANTON;
        this.COD_DISTRITO = COD_DISTRITO;
        this.COD_BARRIO = COD_BARRIO;
        this.OTRAS_SENAS = OTRAS_SENAS;
        this.DSC_CORREO = DSC_CORREO;
        this.CONTRASENA = CONTRASENA;
        this.COD_DISCIPLINA_DEPORTIVA = COD_DISCIPLINA_DEPORTIVA;
        this.COD_DEPORTISTA = COD_DEPORTISTA;
        this.COD_ROL = COD_ROL;
    }
    
    //Metodos SET y GET

    public int getCOD_PERSONA() {
        return COD_PERSONA;
    }

    public void setCOD_PERSONA(int COD_PERSONA) {
        this.COD_PERSONA = COD_PERSONA;
    }

    public int getCOD_TIPO_IDENTIFICACION() {
        return COD_TIPO_IDENTIFICACION;
    }

    public void setCOD_TIPO_IDENTIFICACION(int COD_TIPO_IDENTIFICACION) {
        this.COD_TIPO_IDENTIFICACION = COD_TIPO_IDENTIFICACION;
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

    public String getAPELLIDO2() {
        return APELLIDO2;
    }

    public void setAPELLIDO2(String APELLIDO2) {
        this.APELLIDO2 = APELLIDO2;
    }

    public float getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(float COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public float getCOD_CANTON() {
        return COD_CANTON;
    }

    public void setCOD_CANTON(float COD_CANTON) {
        this.COD_CANTON = COD_CANTON;
    }

    public float getCOD_DISTRITO() {
        return COD_DISTRITO;
    }

    public void setCOD_DISTRITO(float COD_DISTRITO) {
        this.COD_DISTRITO = COD_DISTRITO;
    }

    public float getCOD_BARRIO() {
        return COD_BARRIO;
    }

    public void setCOD_BARRIO(float COD_BARRIO) {
        this.COD_BARRIO = COD_BARRIO;
    }

    public String getOTRAS_SENAS() {
        return OTRAS_SENAS;
    }

    public void setOTRAS_SENAS(String OTRAS_SENAS) {
        this.OTRAS_SENAS = OTRAS_SENAS;
    }

    public String getDSC_CORREO() {
        return DSC_CORREO;
    }

    public void setDSC_CORREO(String DSC_CORREO) {
        this.DSC_CORREO = DSC_CORREO;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }

    public int getCOD_DISCIPLINA_DEPORTIVA() {
        return COD_DISCIPLINA_DEPORTIVA;
    }

    public void setCOD_DISCIPLINA_DEPORTIVA(int COD_DISCIPLINA_DEPORTIVA) {
        this.COD_DISCIPLINA_DEPORTIVA = COD_DISCIPLINA_DEPORTIVA;
    }

    public int getCOD_DEPORTISTA() {
        return COD_DEPORTISTA;
    }

    public void setCOD_DEPORTISTA(int COD_DEPORTISTA) {
        this.COD_DEPORTISTA = COD_DEPORTISTA;
    }

    public int getCOD_ROL() {
        return COD_ROL;
    }

    public void setCOD_ROL(int COD_ROL) {
        this.COD_ROL = COD_ROL;
    }

     
}

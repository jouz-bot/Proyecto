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
public class Rol {
    int COD_ROL;
    String NOMBRE_ROL;

    public Rol() {
    }

    public Rol(int COD_ROL, String NOMBRE_ROL) {
        this.COD_ROL = COD_ROL;
        this.NOMBRE_ROL = NOMBRE_ROL;
    }

    public int getCOD_ROL() {
        return COD_ROL;
    }

    public void setCOD_ROL(int COD_ROL) {
        this.COD_ROL = COD_ROL;
    }

    public String getNOMBRE_ROL() {
        return NOMBRE_ROL;
    }

    public void setNOMBRE_ROL(String NOMBRE_ROL) {
        this.NOMBRE_ROL = NOMBRE_ROL;
    }
    
    
}

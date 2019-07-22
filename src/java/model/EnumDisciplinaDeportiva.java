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
public enum EnumDisciplinaDeportiva {

    //Definicion de Enums
    FUTBOL(1, "Futbol"), CICLISMO(2, "Ciclismo"), ATLETISMO(3, "Atletismo");

    //Definicion de atributos
    public int COD_DISCIPLINA_DEPORTIVA;
    public String DSC_DISPLINA_DEPORTIVA;
    
    //Metodo constrctor

    private EnumDisciplinaDeportiva() {
    }

    private EnumDisciplinaDeportiva(int COD_DISCIPLINA_DEPORTIVA, String DSC_DISPLINA_DEPORTIVA) {
        this.COD_DISCIPLINA_DEPORTIVA = COD_DISCIPLINA_DEPORTIVA;
        this.DSC_DISPLINA_DEPORTIVA = DSC_DISPLINA_DEPORTIVA;
    }
    
    //Metodos SET y GET

    public int getCOD_DISCIPLINA_DEPORTIVA() {
        return COD_DISCIPLINA_DEPORTIVA;
    }

    public void setCOD_DISCIPLINA_DEPORTIVA(int COD_DISCIPLINA_DEPORTIVA) {
        this.COD_DISCIPLINA_DEPORTIVA = COD_DISCIPLINA_DEPORTIVA;
    }

    public String getDSC_DISPLINA_DEPORTIVA() {
        return DSC_DISPLINA_DEPORTIVA;
    }

    public void setDSC_DISPLINA_DEPORTIVA(String DSC_DISPLINA_DEPORTIVA) {
        this.DSC_DISPLINA_DEPORTIVA = DSC_DISPLINA_DEPORTIVA;
    }
    
}

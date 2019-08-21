/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import model.PlanEntrenamiento;
import model.PlanEntrenamientoDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanPlanEntrenamiento")
@SessionScoped
public class beanPlanEntrenamiento implements Serializable {
    //Lista de variables
    private int COD_PLAN_ENTRENAMIENTO = 0;
    private int COD_PERIOCIDAD = 0;
    private Date FECHA_INICIO;
    private Date FECHA_FIN;
    private int COD_ACTIVIDAD_FISICA = 0;
    private String DSC_PLAN_ENTRENAMIENTO;
    private String DURACION;
    private int REPETICIONES = 0;
    private int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = 0;
    private LinkedList<SelectItem> listaPlaCmb= new LinkedList();
    
    private PlanEntrenamiento planEntrenamiento;
    private PlanEntrenamientoDB planEntrenamientoDB = new PlanEntrenamientoDB();
    
    /**
     * Creates a new instance of beanPlanEntrenamiento
     */
    public beanPlanEntrenamiento() {
    }
    
    //Metodos SET y GET

    public LinkedList<SelectItem> getListaPlaCmb() throws SNMPExceptions, SQLException{

        
        LinkedList<PlanEntrenamiento> lista= new LinkedList<PlanEntrenamiento>();
        PlanEntrenamientoDB planDB= new PlanEntrenamientoDB();
        
        lista=planDB.ComboPlan();
        
        LinkedList resultList= new LinkedList();
        resultList.add(new SelectItem(0,"Seleccione su plan"));
        
        for(Iterator iter= lista.iterator();
                iter.hasNext();){
            
            PlanEntrenamiento plan= (PlanEntrenamiento)iter.next();
          int  Cod_Plan = plan.getCOD_PLAN_ENTRENAMIENTO();
          String  dsc_plan = plan.getDSC_PLAN_ENTRENAMIENTO();
            resultList.add(new SelectItem(Cod_Plan,dsc_plan));
            
        }
        return resultList;
    }

    public void setListaPlaCmb(LinkedList<SelectItem> listaPlaCmb) {
        this.listaPlaCmb = listaPlaCmb;
    }
    
    

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

    public PlanEntrenamiento getPlanEntrenamiento() {
        return planEntrenamiento;
    }

    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        this.planEntrenamiento = planEntrenamiento;
    }

    public PlanEntrenamientoDB getPlanEntrenamientoDB() {
        return planEntrenamientoDB;
    }

    public void setPlanEntrenamientoDB(PlanEntrenamientoDB planEntrenamientoDB) {
        this.planEntrenamientoDB = planEntrenamientoDB;
    }
    
}

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
import model.RegistroActividad;
import model.RegistroActividadDB;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.naming.NamingException;
import model.Persona;
import model.PersonaDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanRegistroActividad")
@SessionScoped
public class beanRegistroActividad implements Serializable {
    //Lista de variables
    private int COD_REGISTRO_ACTIVIDAD;
    private Date FECHA_REGISTRO;
    private String FECHA_ACTIVIDAD;
    private String TIEMPO;
    private int REPETICIONES;
    private int COD_ACTIVIDAD_FISICA;
    private int COD_PLAN_ENTRENAMIENTO;
    private String mensaje;
     private LinkedList<SelectItem> listaPlaCmb= new LinkedList();
    
    private RegistroActividad registroActividad;
    private RegistroActividadDB registroActividadDB = new RegistroActividadDB();
    /**
     * Creates a new instance of beanRegistroActividad
     */
    public beanRegistroActividad() {
    }
    
    //Metodos SET y GET

    public LinkedList<SelectItem> getListaPlaCmb() throws SNMPExceptions, SQLException {
        return listaPlaCmb;
    }
    
    

    public LinkedList<SelectItem> getListaPlaCmb1() throws SNMPExceptions, SQLException{

        int  Cod_Plan = 0;
        String  dsc_plan = "";
        
        LinkedList<PlanEntrenamiento> lista= new LinkedList<PlanEntrenamiento>();
        PlanEntrenamientoDB planDB= new PlanEntrenamientoDB();
        
        lista=planDB.ComboPlan();
        
        LinkedList resultList= new LinkedList();
        resultList.add(new SelectItem(0,"Seleccione su plan"));
        
        for(Iterator iter= lista.iterator();
                iter.hasNext();){
            
            PlanEntrenamiento plan= (PlanEntrenamiento)iter.next();
            Cod_Plan = plan.getCOD_PLAN_ENTRENAMIENTO();
            dsc_plan = plan.getDSC_PLAN_ENTRENAMIENTO();
            resultList.add(new SelectItem(Cod_Plan,dsc_plan));
            
        }
        return resultList;
    }

    public void setListaPlaCmb(LinkedList<SelectItem> listaPlaCmb) {
        this.listaPlaCmb = listaPlaCmb;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    
 

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

    public String getFECHA_ACTIVIDAD() {
        return FECHA_ACTIVIDAD;
    }

    public void setFECHA_ACTIVIDAD(String FECHA_ACTIVIDAD) {
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
    
        public void guardarRegistroActividad() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        RegistroActividad vRe = new RegistroActividad();
        RegistroActividadDB vDB = new RegistroActividadDB();
        try {

        

                vRe.setFECHA_ACTIVIDAD(new SimpleDateFormat("dd/MM/yyyy").parse(this.getFECHA_ACTIVIDAD()));
                vRe.setTIEMPO(this.getTIEMPO());
                vRe.setREPETICIONES(this.getREPETICIONES());
                vRe.setCOD_PLAN_ENTRENAMIENTO(this.getCOD_PLAN_ENTRENAMIENTO());
                
                

                vDB.guardarRegistroActividad(vRe);
                this.setMensaje("Actividad registrada exitosamente!");
            

        } catch (Exception e) {
            this.setMensaje("Error al Registrar Acticidad!");
        }

    }
    
}

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
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import model.Provincias;
import model.ProvinciasDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanProvincias")
@SessionScoped
public class beanProvincias implements Serializable {
    int COD_PROVINCIA;
    String DSC_CORTA_PROVINCIA;
    String DSC_PROVINCIA;
    int LOG_ACTIVO;
    LinkedList<SelectItem> listaPro = new LinkedList<>();
    LinkedList<Provincias> listaTablaProvincia = new LinkedList<Provincias>();

    public LinkedList<Provincias> getListaTablaProvincia() throws SNMPExceptions, SQLException {
        
        LinkedList<Provincias> lista = new LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();
        
        lista = pDB.moTodo();
        
        LinkedList resultLista = new LinkedList();
           
        resultLista = lista;       
        
        return resultLista; 
    }

    public void setListaTablaProvincia(LinkedList<Provincias> listaTablaProvincia) {
        this.listaTablaProvincia = listaTablaProvincia;
    }
    
    Provincias pro;
    ProvinciasDB proDB;
   
    /**
     * Creates a new instance of beanProvincias
     */
    public beanProvincias() {
    }
    

    public void setListPro(LinkedList<SelectItem>listProv) {
        this.listaPro= listProv;
    }

    public LinkedList<SelectItem> getListaPro() throws SNMPExceptions, SQLException{
        String dscCortaProvincia="";
        float codigoProvincia = 0;
        
        LinkedList<Provincias> lista = new LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();
        
        lista = pDB.moTodo();
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione Provincia"));
        
        for (Iterator iter = lista.iterator();
                iter.hasNext();) {
        
            Provincias pro = (Provincias) iter.next();
            dscCortaProvincia = pro.getDSC_CORTA_PROVINCIA();
            codigoProvincia = pro.getCOD_PROVINCIA();
            resultList.add(new SelectItem(codigoProvincia, 
                    dscCortaProvincia));
         }         
         return resultList; 
        
    }

    public int getCOD_PROVINCIA() {
        return COD_PROVINCIA;
    }

    public void setCOD_PROVINCIA(int COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public String getDSC_CORTA_PROVINCIA() {
        return DSC_CORTA_PROVINCIA;
    }

    public void setDSC_CORTA_PROVINCIA(String DSC_CORTA_PROVINCIA) {
        this.DSC_CORTA_PROVINCIA = DSC_CORTA_PROVINCIA;
    }

    public String getDSC_PROVINCIA() {
        return DSC_PROVINCIA;
    }

    public void setDSC_PROVINCIA(String DSC_PROVINCIA) {
        this.DSC_PROVINCIA = DSC_PROVINCIA;
    }

    public int getLOG_ACTIVO() {
        return LOG_ACTIVO;
    }

    public void setLOG_ACTIVO(int LOG_ACTIVO) {
        this.LOG_ACTIVO = LOG_ACTIVO;
    }

    public Provincias getPro() {
        return pro;
    }

    public void setPro(Provincias pro) {
        this.pro = pro;
    }

    public ProvinciasDB getProDB() {
        return proDB;
    }

    public void setProDB(ProvinciasDB proDB) {
        this.proDB = proDB;
    }
    
}

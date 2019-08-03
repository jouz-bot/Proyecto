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

    float cod_provincia;
    String dsc_corta_provincia;
    String dsc_provincia = "Alajuela";
    float log_activo;
    LinkedList<SelectItem> listaPro = new LinkedList<>();
    LinkedList<Provincias> listaTablaProvincia = new LinkedList<Provincias>();

    public LinkedList<Provincias> getListaTablaProvincia()
            throws SNMPExceptions, SQLException {

        LinkedList<Provincias> lista = new LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();

        lista = pDB.moTodo();

        LinkedList resultLista = new LinkedList();

        resultLista = lista;
        return resultLista;

    }

    public void setListaTablaProvincia(LinkedList<
            Provincias> listaTablaProvincia) {
        this.listaTablaProvincia = listaTablaProvincia;
    }

    Provincias pro;
    ProvinciasDB proDB;

    public beanProvincias() {
    }

    public void setListPro(LinkedList<SelectItem> listProv) {
        this.listaPro = listProv;
    }

    public LinkedList<SelectItem> getListaPro()
            throws SNMPExceptions, SQLException {
        String dscCortaProvincia = "";
        float codigoProvincia = 0;

        LinkedList<Provincias> lista = new LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();

        lista = pDB.moTodo();

        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0,
                "Seleccione Provincia"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            Provincias pro = (Provincias) iter.next();
            dscCortaProvincia = pro.getDsc_corta_provincia();
            codigoProvincia = pro.getCod_provincia();
            resultList.add(new SelectItem(codigoProvincia,
                    dscCortaProvincia));
        }
        return resultList;

    }

    public float getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(float cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getDsc_corta_provincia() {
        return dsc_corta_provincia;
    }

    public void setDsc_corta_provincia(String dsc_corta_provincia) {
        this.dsc_corta_provincia = dsc_corta_provincia;
    }

    public String getDsc_provincia() {
        return dsc_provincia;
    }

    public void setDsc_provincia(String dsc_provincia) {
        this.dsc_provincia = dsc_provincia;
    }

    public float getLog_activo() {
        return log_activo;
    }

    public void setLog_activo(float log_activo) {
        this.log_activo = log_activo;
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

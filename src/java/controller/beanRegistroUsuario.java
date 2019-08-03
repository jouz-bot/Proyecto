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
import javax.naming.NamingException;
import model.Persona;
import model.PersonaDB;
import model.Provincias;
import model.ProvinciasDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanRegistroUsuario")
@SessionScoped
public class beanRegistroUsuario implements Serializable {

    /**
     * Creates a new instance of beanRegistroUsuario
     */
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
    int COD_DEPORTISTA = 0;
    int COD_ROL;
    
    String mensaje = "";
    
    public beanRegistroUsuario() {
    }

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

    public void setCOD_PROVINCIA(int COD_PROVINCIA) {
        this.COD_PROVINCIA = COD_PROVINCIA;
    }

    public float getCOD_CANTON() {
        return COD_CANTON;
    }

    public void setCOD_CANTON(int COD_CANTON) {
        this.COD_CANTON = COD_CANTON;
    }

    public float getCOD_DISTRITO() {
        return COD_DISTRITO;
    }

    public void setCOD_DISTRITO(int COD_DISTRITO) {
        this.COD_DISTRITO = COD_DISTRITO;
    }

    public float getCOD_BARRIO() {
        return COD_BARRIO;
    }

    public void setCOD_BARRIO(int COD_BARRIO) {
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

    public String getMensaje() {
        return mensaje;
    }

    public void limpiarCampos() {
        this.setAPELLIDO1("");
        this.setAPELLIDO2("");
        this.setCOD_BARRIO(0);
        this.setCOD_CANTON(0);
        this.setCOD_DEPORTISTA(0);
        this.setCOD_DISCIPLINA_DEPORTIVA(0);
        this.setCOD_DISTRITO(0);
        this.setCOD_PERSONA(0);
        this.setCOD_PROVINCIA(0);
        this.setCOD_ROL(0);
        this.setCOD_TIPO_IDENTIFICACION(0);
        this.setCONTRASENA("");
        this.setDSC_CORREO("");
        this.setMensaje("");
        this.setNOMBRE_PERSONA("");
        this.setOTRAS_SENAS("");
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void guardarPersona() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        Persona vCan = new Persona();
        PersonaDB vDB = new PersonaDB();

        vCan.setCOD_PERSONA(this.getCOD_PERSONA());
        vCan.setNOMBRE_PERSONA(this.getNOMBRE_PERSONA());
        vCan.setAPELLIDO1(this.getAPELLIDO1());
        vCan.setAPELLIDO2(this.getAPELLIDO2());
        vCan.setCOD_PROVINCIA(this.getCOD_PROVINCIA());
        vCan.setCOD_CANTON(this.getCOD_CANTON());
        vCan.setCOD_DISTRITO(this.getCOD_DISTRITO());
        vCan.setCOD_BARRIO(this.getCOD_BARRIO());
        vCan.setOTRAS_SENAS(this.getOTRAS_SENAS());
        vCan.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
        vCan.setCOD_DISCIPLINA_DEPORTIVA(this.getCOD_DISCIPLINA_DEPORTIVA());
        vCan.setCONTRASENA(this.getCONTRASENA());
        vCan.setDSC_CORREO(this.getDSC_CORREO());
        vCan.setCOD_ROL(this.getCOD_ROL());

        vDB.guardarPersona(vCan);
        this.setMensaje("Se ha guardado el usuario correctamente");
    }

    float cod_provincia;
    String dsc_corta_provincia;
    String dsc_provincia = "Alajuela";
    float log_activo;
    LinkedList<SelectItem> listaPro = new LinkedList<>();
    LinkedList<Provincias> listaTablaProvincia = new 
        LinkedList<Provincias>();

    public LinkedList<Provincias> getListaTablaProvincia() 
            throws SNMPExceptions, SQLException {
        
        LinkedList<Provincias> lista = new 
                    LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();
        
        lista = pDB.moTodo();
        
        LinkedList resultLista = new LinkedList();
           
        resultLista=lista;       
        return resultLista; 

    }

    public void setListaTablaProvincia(LinkedList<Provincias> listaTablaProvincia) {
        this.listaTablaProvincia = listaTablaProvincia;
    }
    
    Provincias pro;
    ProvinciasDB proDB;

    public void setListPro(LinkedList<SelectItem> listProv) {
        this.listaPro= listProv;
    }

    public LinkedList<SelectItem> getListaPro() 
            throws SNMPExceptions, SQLException{
        String dscCortaProvincia="";
        float codigoProvincia=0;
        
        LinkedList<Provincias> lista = new 
        LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();
        
        lista = pDB.moTodo();
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, 
                "Seleccione Provincia"));
        
        for (Iterator iter= lista.iterator();
                iter.hasNext();) {
        
            Provincias pro = (Provincias) iter.next();
            dscCortaProvincia=pro.getDsc_corta_provincia();
            codigoProvincia=pro.getCod_provincia();
            resultList.add(new SelectItem(codigoProvincia, 
                    dscCortaProvincia));
         }         
         return resultList; 
        
    }
}

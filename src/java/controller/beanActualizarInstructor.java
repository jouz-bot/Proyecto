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
import java.util.LinkedList;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import model.Barrio;
import model.BarrioDB;
import model.Cantones;
import model.CantonesDB;
import model.Deportista;
import model.DeportistaDB;
import model.Distritos;
import model.DistritosDB;
import model.Persona;
import model.PersonaDB;
import model.Provincias;
import model.ProvinciasDB;
import model.Telefono;
import model.TelefonoDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanActualizarInstructor")
@SessionScoped
public class beanActualizarInstructor implements Serializable {

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
    final int COD_DEPORTISTA = 0;
    final int COD_ROL = 2;
    double PESO;
    double TALLA;
    double ALTURA;
    String DSC_OBJETIVOS;

    String DSC_TELEFONO;

    String mensaje = "";
    String mensajeTelefono = "";

    Persona oPersona;
    int login;

    /**
     * Creates a new instance of beanActualizarInstructor
     */
    public beanActualizarInstructor() throws SNMPExceptions, SQLException {
        getConsultarSesion();
        cargarUsuarioSesion();
    }

    public void getConsultarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Object user = session.get("Usuario");

        if (user != null) {
            try {
                this.oPersona = (Persona) user;
                int id = oPersona.getCOD_PERSONA();
                this.setLogin(id);

            } catch (ClassCastException e) {

            }
        } else {
            context.invalidateSession();
        }
    }
    
    public void cargarUsuarioSesion() throws SNMPExceptions, SQLException{
        Persona oPer = new Persona();
        oPer = this.getoPersona();
        
        this.setCOD_TIPO_IDENTIFICACION(oPer.getCOD_TIPO_IDENTIFICACION());
        this.setCOD_PERSONA(oPer.getCOD_PERSONA());
        this.setNOMBRE_PERSONA(oPer.getNOMBRE_PERSONA());
        this.setAPELLIDO1(oPer.getAPELLIDO1());
        this.setAPELLIDO2(oPer.getAPELLIDO2());
        this.setCOD_PROVINCIA(oPer.getCOD_PROVINCIA());
        this.setCOD_CANTON(oPer.getCOD_CANTON());
        this.setCOD_DISTRITO(oPer.getCOD_DISTRITO());
        this.setCOD_BARRIO(oPer.getCOD_BARRIO());
        this.setOTRAS_SENAS(oPer.getOTRAS_SENAS());
        this.setDSC_CORREO(oPer.getDSC_CORREO());
        this.setCONTRASENA(oPer.getCONTRASENA());
        this.setCOD_DISCIPLINA_DEPORTIVA(oPer.getCOD_DISCIPLINA_DEPORTIVA());
        
        //faltan los telefonos
        
    }

    public void limpiarCampos() {
        this.setAPELLIDO1("");
        this.setAPELLIDO2("");
        this.setCOD_BARRIO(0);
        this.setCOD_CANTON(0);
        this.setCOD_DISCIPLINA_DEPORTIVA(0);
        this.setCOD_DISTRITO(0);
        this.setCOD_PERSONA(0);
        this.setCOD_PROVINCIA(0);
        this.setCOD_TIPO_IDENTIFICACION(0);
        this.setCONTRASENA("");
        this.setDSC_CORREO("");
        this.setMensaje("");
        this.setNOMBRE_PERSONA("");
        this.setOTRAS_SENAS("");
        this.limpiarTelefono();
    }

    public void limpiarCamposDepo() {
        this.setAPELLIDO1("");
        this.setAPELLIDO2("");
        this.setCOD_BARRIO(0);
        this.setCOD_CANTON(0);
        this.setCOD_DISCIPLINA_DEPORTIVA(0);
        this.setCOD_DISTRITO(0);
        this.setCOD_PERSONA(0);
        this.setCOD_PROVINCIA(0);
        this.setCOD_TIPO_IDENTIFICACION(0);
        this.setCONTRASENA("");
        this.setDSC_CORREO("");
        this.setMensaje("");
        this.setNOMBRE_PERSONA("");
        this.setOTRAS_SENAS("");

        this.setALTURA(0);
        this.setTALLA(0);
        this.setPESO(0);
        this.setDSC_OBJETIVOS("");
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

//    Cargar provincias
    public LinkedList<SelectItem> getListaProvincia() throws SNMPExceptions, SQLException {
        float idProvincia;
        String nombreProvincia;

        LinkedList<Provincias> lista = new LinkedList<Provincias>();
        ProvinciasDB pDB = new ProvinciasDB();

        try {
            lista = pDB.moTodo();
        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();
        //    resultList.add(new SelectItem(0, "Seleccione una Provincia"));

        for (Provincias pro : lista) {
            idProvincia = pro.getCod_provincia();
            nombreProvincia = pro.getDsc_provincia();
            resultList.add(new SelectItem(idProvincia, nombreProvincia));
        }
        return resultList;

    }
//    Cargar cantones

    public LinkedList<SelectItem> getListaCantonPorProvincia() throws SNMPExceptions, SQLException {
        float idCan;
        String nombreCan = "";

        LinkedList<Cantones> lista = new LinkedList<Cantones>();
        CantonesDB cDB = new CantonesDB();

        if (this.COD_PROVINCIA == 0) {
            return null;
        }
        try {
            lista = cDB.seleccionarCantonesPorProvincia(COD_PROVINCIA);
        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();
//        resultList.add(new SelectItem(0, "Seleccione un Canton"));

        for (Cantones pro : lista) {
            idCan = pro.getCOD_CANTON();
            nombreCan = pro.getDSC_CANTON();
            resultList.add(new SelectItem(idCan, nombreCan));
        }
        return resultList;

    }

//    Cargar distritos
    public LinkedList<SelectItem> getListaDistritoPorCanton() throws SNMPExceptions, SQLException {
        float idDistrito;
        String nombreDistrito = "";

        LinkedList<Distritos> lista = new LinkedList<Distritos>();
        DistritosDB dDB = new DistritosDB();

        if (this.COD_PROVINCIA == 0) {
            return null;
        }

        if (this.COD_CANTON == 0) {
            return null;
        }

        try {
            lista = dDB.seleccionarDistritoPorCanton(this.COD_PROVINCIA, this.COD_CANTON);

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();

        for (Distritos pro : lista) {
            idDistrito = pro.getCOD_DISTRITO();
            nombreDistrito = pro.getDSC_DISTRITO();
            resultList.add(new SelectItem(idDistrito, nombreDistrito));
        }
        return resultList;
    }

    //    Cargar barrio
    public LinkedList<SelectItem> getListaBarrioPorDistrito() throws SNMPExceptions, SQLException {
        float idBarrio;
        String nombreBarrio = "";

        LinkedList<Barrio> lista = new LinkedList<Barrio>();
        BarrioDB dDB = new BarrioDB();

        if (this.COD_PROVINCIA == 0) {
            return null;
        }

        if (this.COD_CANTON == 0) {
            return null;
        }

        if (this.COD_DISTRITO == 0) {
            return null;
        }

        try {
            lista = dDB.seleccionarBarrioPorDistrito(this.COD_PROVINCIA, this.COD_CANTON, this.COD_DISTRITO);

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString()));
        }

        LinkedList resultList = new LinkedList();

        for (Barrio pro : lista) {
            idBarrio = pro.getCOD_BARRIO();
            nombreBarrio = pro.getDSC_BARRIO();
            resultList.add(new SelectItem(idBarrio, nombreBarrio));
        }
        return resultList;
    }
//    Guardar instructor

    public void guardarPersona() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        Persona vCan = new Persona();
        PersonaDB vDB = new PersonaDB();
        try {

            if (this.getCOD_TIPO_IDENTIFICACION() == 0) {
                this.setMensaje("Seleccione un tipo de identificacion");
            } else if (this.getLogin() == 0) {
                this.setMensaje("El usuario no se encunetra en sesion, ingrese nuevamente");
            } else if (this.getCOD_PERSONA() == 0) {
                this.setMensaje("Escriba el número de identificación");
//            } else if (vDB.consultaPersona(this.getCOD_PERSONA()) == true) {
//                this.setMensaje("El usuario ya existe en la base de datos");
            } else if (this.getNOMBRE_PERSONA().equals("")) {
                this.setMensaje("Escriba el nombre del usuario");
            } else if (this.getAPELLIDO1().equals("")) {
                this.setMensaje("Ingrese el primer apellido del usuario");
            } else if (this.getAPELLIDO2().equals("")) {
                this.setMensaje("Ingrese el segundo apellido del usuario");
            } else if (this.getCOD_PROVINCIA() == 0) {
                this.setMensaje("Debe seleccionar la Provincia");
            } else if (this.getCOD_CANTON() == 0) {
                this.setMensaje("Debe seleccionar el Cantón");
            } else if (this.getCOD_DISTRITO() == 0) {
                this.setMensaje("Debe seleccionar el Distrito");
            } else if (this.getCOD_BARRIO() == 0) {
                this.setMensaje("Debe seleccionar el Barrio");
            } else if (this.getOTRAS_SENAS().equals("")) {
                this.setMensaje("Ingreso Otras señas");
            } else if (this.getDSC_CORREO().equals("")) {
                this.setMensaje("Debe proporcionar un correo");
            } else if (this.getCONTRASENA().equals("")) {
                this.setMensaje("Debe ingresar una contraseña temporal");
            } else if (this.getCOD_DISCIPLINA_DEPORTIVA() == 0) {
                this.setMensaje("Debe seleccionar una disciplina");
            } else {

                vCan.setCOD_PERSONA(this.getCOD_PERSONA());
                vCan.setCOD_TIPO_IDENTIFICACION(this.getCOD_TIPO_IDENTIFICACION());
                vCan.setNOMBRE_PERSONA(this.getNOMBRE_PERSONA());
                vCan.setAPELLIDO1(this.getAPELLIDO1());
                vCan.setAPELLIDO2(this.getAPELLIDO2());
                vCan.setCOD_PROVINCIA(this.getCOD_PROVINCIA());
                vCan.setCOD_CANTON(this.getCOD_CANTON());
                vCan.setCOD_DISTRITO(this.getCOD_DISTRITO());
                vCan.setCOD_BARRIO(this.getCOD_BARRIO());
                vCan.setOTRAS_SENAS(this.getOTRAS_SENAS());
                vCan.setDSC_CORREO(this.getDSC_CORREO());
                vCan.setCONTRASENA(this.getCONTRASENA());
                vCan.setCOD_DISCIPLINA_DEPORTIVA(this.getCOD_DISCIPLINA_DEPORTIVA());
                vCan.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
                vCan.setCOD_ROL(2);

                vDB.actualizarInstructor(vCan);

                
                this.setMensaje("Actualizacion exitosa!");
            }

        } catch (Exception e) {
            this.setMensaje("Error al actualizar al Instructor!");
        }

    }

    //    Guardar deportista
    public void guardarDeportista() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        Persona vPersona = new Persona();
        PersonaDB vPersonaDB = new PersonaDB();
        Deportista vDeportista = new Deportista();
        DeportistaDB vDeportistaBD = new DeportistaDB();
        if (this.getCOD_TIPO_IDENTIFICACION() == 0) {
            this.setMensaje("Seleccione un tipo de identificacion");
        } else if (this.getCOD_PERSONA() == 0) {
            this.setMensaje("Escriba el número de identificación");
        } else if (vPersonaDB.consultaPersona(this.getCOD_PERSONA()) == true) {
            this.setMensaje("El usuario ya existe en la base de datos");
        } else if (this.getNOMBRE_PERSONA().equals("")) {
            this.setMensaje("Escriba el nombre del usuario");
        } else if (this.getAPELLIDO1().equals("")) {
            this.setMensaje("Ingrese el primer apellido del usuario");
        } else if (this.getAPELLIDO2().equals("")) {
            this.setMensaje("Ingrese el segundo apellido del usuario");
        } else if (this.getCOD_PROVINCIA() == 0) {
            this.setMensaje("Debe seleccionar la Provincia");
        } else if (this.getCOD_CANTON() == 0) {
            this.setMensaje("Debe seleccionar el Cantón");
        } else if (this.getCOD_DISTRITO() == 0) {
            this.setMensaje("Debe seleccionar el Distrito");
        } else if (this.getCOD_BARRIO() == 0) {
            this.setMensaje("Debe seleccionar el Barrio");
        } else if (this.getOTRAS_SENAS().equals("")) {
            this.setMensaje("Ingreso Otras señas");
        } else if (this.getDSC_CORREO().equals("")) {
            this.setMensaje("Debe proporcionar un correo");
        } else if (this.getCONTRASENA().equals("")) {
            this.setMensaje("Debe ingresar una contraseña temporal");
        } else if (this.getCOD_DISCIPLINA_DEPORTIVA() == 0) {
            this.setMensaje("Debe seleccionar una disciplina");
        } else {
            //datos persona
            vPersona.setCOD_PERSONA(this.getCOD_PERSONA());
            vPersona.setCOD_TIPO_IDENTIFICACION(this.getCOD_TIPO_IDENTIFICACION());
            vPersona.setNOMBRE_PERSONA(this.getNOMBRE_PERSONA());
            vPersona.setAPELLIDO1(this.getAPELLIDO1());
            vPersona.setAPELLIDO2(this.getAPELLIDO2());
            vPersona.setCOD_PROVINCIA(this.getCOD_PROVINCIA());
            vPersona.setCOD_CANTON(this.getCOD_CANTON());
            vPersona.setCOD_DISTRITO(this.getCOD_DISTRITO());
            vPersona.setCOD_BARRIO(this.getCOD_BARRIO());
            vPersona.setOTRAS_SENAS(this.getOTRAS_SENAS());
            vPersona.setDSC_CORREO(this.getDSC_CORREO());
            vPersona.setCONTRASENA(this.getCONTRASENA());
            vPersona.setCOD_DISCIPLINA_DEPORTIVA(this.getCOD_DISCIPLINA_DEPORTIVA());
            vPersona.setCOD_DEPORTISTA(this.getCOD_DEPORTISTA());
            vPersona.setCOD_ROL(3);

            //datos dportista
            vDeportista.setCOD_PERSONA(vPersona.getCOD_PERSONA());
            vDeportista.setPESO(this.getPESO());
            vDeportista.setTALLA(this.getTALLA());
            vDeportista.setALTURA(this.getALTURA());
            vDeportista.setDSC_OBJETIVOS(this.getDSC_OBJETIVOS());
        }
        try {

            vDeportistaBD.guardarDeportista(vPersona, vDeportista);
            this.limpiarCamposDepo();
            this.setMensaje("Deportista guardado exitosamente!");

        } catch (Exception e) {
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.addMessage(null, new FacesMessage("Error", e.toString() + "Error al guardar al Instructor"));
        }

    }

//    Guardar telefono
    public void guardarTelefono() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        Persona oUsuario = new Persona();
        PersonaDB oUsuarioDB = new PersonaDB();

        if (this.COD_PERSONA == 0) {
            this.setMensajeTelefono("Debe de digitar la identificación!");
        }

        if (oUsuarioDB.consultaPersona(this.getCOD_PERSONA()) == false) {
            this.setMensajeTelefono("Debe de registrar al Usuario antes de asignar un telefono");
        }

        if (this.DSC_TELEFONO.equals("")) {
            this.setMensajeTelefono("Debe de ingresar un número de telefono");
        }

        try {
            Telefono vCan = new Telefono();
            TelefonoDB vDB = new TelefonoDB();

            vCan.setDSC_TELEFONO(this.getDSC_TELEFONO());
            vCan.setCOD_PERSONA(this.getCOD_PERSONA());

            vDB.guardarTelefono(vCan);

            this.limpiarTelefono();
            this.setMensaje("Telefono guardado exitosamente!");

        } catch (Exception e) {
            this.setMensajeTelefono("Error al guardar el Telefono");
        }
    }

//        Limpiar telefono
    public void limpiarTelefono() {
        this.setDSC_TELEFONO("");
        this.setMensajeTelefono("");
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

    public double getPESO() {
        return PESO;
    }

    public void setPESO(double PESO) {
        this.PESO = PESO;
    }

    public double getTALLA() {
        return TALLA;
    }

    public void setTALLA(double TALLA) {
        this.TALLA = TALLA;
    }

    public double getALTURA() {
        return ALTURA;
    }

    public void setALTURA(double ALTURA) {
        this.ALTURA = ALTURA;
    }

    public String getDSC_OBJETIVOS() {
        return DSC_OBJETIVOS;
    }

    public void setDSC_OBJETIVOS(String DSC_OBJETIVOS) {
        this.DSC_OBJETIVOS = DSC_OBJETIVOS;
    }

    public String getDSC_TELEFONO() {
        return DSC_TELEFONO;
    }

    public void setDSC_TELEFONO(String DSC_TELEFONO) {
        this.DSC_TELEFONO = DSC_TELEFONO;
    }

    public String getMensajeTelefono() {
        return mensajeTelefono;
    }

    public void setMensajeTelefono(String mensajeTelefono) {
        this.mensajeTelefono = mensajeTelefono;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getCOD_DEPORTISTA() {
        return COD_DEPORTISTA;
    }

    public int getCOD_ROL() {
        return COD_ROL;
    }

    public String getMensaje() {
        return mensaje;
    }

}

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
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.ContrasenaPersona;
import model.ContrasenaPersonaDB;
import model.Persona;
import model.PersonaDB;

/**
 *
 * @author Jose_Cespedes
 */
@Named(value = "beanCambiarContrasena")
@SessionScoped
public class beanCambiarContrasena implements Serializable {

    String password1;
    String password2;
    int login = 0;
    String mensajeError;
    
    ContrasenaPersona oContrasenaPersona;
    ContrasenaPersonaDB oContrasenaPersonaDB;
    Persona oPersona;
    Persona usuarioIngresado;
    
    
    /**
     * Creates a new instance of beanCambiarContrasena
     */
    public beanCambiarContrasena() {
        this.getConsultarSesion();
    }

    public void getConsultarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Object user = session.get("Usuario");

        if (user != null) {
            try {
                    oPersona = (Persona)user;
                    int id = oPersona.getCOD_PERSONA();
                    this.setLogin(id);
//                Persona oUser = (Persona) user;
//                this.setoPersona(oUser);
//                this.setLogin(oUser.getCOD_PERSONA());

            } catch (ClassCastException e) {

            }
        } else {
            context.invalidateSession();
        }

    }

    public void guardarContrasena() throws SNMPExceptions, SQLException {
        ContrasenaPersona vDB = new ContrasenaPersona();
        ContrasenaPersonaDB cDB = new ContrasenaPersonaDB();
        Persona per = new Persona();
        PersonaDB perDB = new PersonaDB();
        Date fecha = java.util.Calendar.getInstance().getTime();

        if (this.getPassword1().equals("")) {
            this.setMensajeError("Debe de ingresar una nueva contraseña");
        } else if (this.getPassword1().equals(this.getPassword1()) == false) {
            this.setMensajeError("Debe de confirmar su nueva contraseña");
        } else if (this.validarContrasena(this.getPassword1()) != true) {
            this.setMensajeError("La contraseña no cumple con los requisitos de seguridad minimos");
        } else if (this.getLogin() == 0) {
            this.setMensajeError("No hay un usuario en sesion para cambiar la contraseña");
        } else {

            try {
                vDB.setCOD_PERSONA(this.getLogin());
                vDB.setDSC_CONTRESANA(this.getPassword1());
                vDB.setFECHA(fecha);
                vDB.setACTIVO(1);

                cDB.guardarContrasena(vDB);

                this.setMensajeError("Contraseña actualizada correctamente");
                perDB.cambiarContrasena(this.getLogin(), this.getPassword1());
            } catch (Exception e) {
            this.setMensajeError("Error al actualizar la contraseña");
            }
        }
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public ContrasenaPersona getoContrasenaPersona() {
        return oContrasenaPersona;
    }

    public void setoContrasenaPersona(ContrasenaPersona oContrasenaPersona) {
        this.oContrasenaPersona = oContrasenaPersona;
    }

    public ContrasenaPersonaDB getoContrasenaPersonaDB() {
        return oContrasenaPersonaDB;
    }

    public void setoContrasenaPersonaDB(ContrasenaPersonaDB oContrasenaPersonaDB) {
        this.oContrasenaPersonaDB = oContrasenaPersonaDB;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public Persona getUsuarioIngresado() {
        return usuarioIngresado;
    }

    public void setUsuarioIngresado(Persona usuarioIngresado) {
        this.usuarioIngresado = usuarioIngresado;
    }
    
    public boolean validarContrasena(String pass) {
        String contra = pass;
        boolean valido = false;
        int countNum = 0;
        int countLet = 0;
        int count = 0;

        for (int i = 0; i < contra.length(); i++) {
            if (Character.isLetter(contra.charAt(i))) {
                countLet++;
            } else if (Character.isDigit(contra.charAt(i))){
                countNum++;
            } else if (!Character.isAlphabetic(contra.charAt(i)) || !Character.isDigit(contra.charAt(i))){
                return valido;
            }
            count++;
        }
        if (count >= 10 && countLet >1 && countNum > 1) {
            valido = true;
        }
        return valido;
    }
}

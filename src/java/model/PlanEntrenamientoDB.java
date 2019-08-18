/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author Jose_Cespedes
 */
public class PlanEntrenamientoDB {
  
     private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<AsignacionDeportistaInstructor> listaP = new LinkedList<AsignacionDeportistaInstructor>();

    public PlanEntrenamientoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public PlanEntrenamientoDB() {
        super();
    }
    
    
    
}

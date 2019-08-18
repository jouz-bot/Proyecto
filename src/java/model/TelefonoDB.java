/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Jose_Cespedes
 */
public class TelefonoDB {
private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;  

    private LinkedList<Telefono> listaP = new LinkedList<Telefono>();
    
    public TelefonoDB (Connection conn) {
        accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
    }
    
        public TelefonoDB() {
        super();
    }

    public void guardarTelefono(Telefono votoC) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        //Se obtienen los valores del objeto Cliente
       Telefono d = new Telefono();
        d = votoC;

        //Datos de CLiente

        String dsc_telefono = d.getDSC_TELEFONO();
        int numPersona = d.getCOD_PERSONA();

        //Se crea la sentencia de actualización
        String insert
                = "INSERT INTO TELEFONO(DSC_TELEFONO, COD_PERSONA) VALUES ("
                + " '" + dsc_telefono + "', " + numPersona + ");";
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(insert);
    }
    
}

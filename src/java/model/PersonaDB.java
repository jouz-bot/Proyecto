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
public class PersonaDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<Persona> listaP = new LinkedList<Persona>();

    public PersonaDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public PersonaDB() {
        super();
    }

    public void guardarPersona(Persona personaC) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        //Se obtienen los valores del objeto Cliente
       Persona d = new Persona();
        d = personaC;

        //Datos de CLiente
    int COD_PERSONA = d.getCOD_PERSONA();
    int COD_TIPO_IDENTIFICACION = d.getCOD_TIPO_IDENTIFICACION();
    String NOMBRE_PERSONA = d.getNOMBRE_PERSONA();
    String APELLIDO1 = d.getAPELLIDO1();
    String APELLIDO2 = d.getAPELLIDO2();
    float COD_PROVINCIA = d.getCOD_PROVINCIA();
    float COD_CANTON = d.getCOD_CANTON();
    float COD_DISTRITO = d.getCOD_DISTRITO();
    float COD_BARRIO = d.getCOD_BARRIO();
    String OTRAS_SENAS = d.getOTRAS_SENAS();
    String DSC_CORREO = d.getDSC_CORREO();
    String CONTRASENA = d.getCONTRASENA();
    int COD_DISCIPLINA_DEPORTIVA = d.getCOD_DISCIPLINA_DEPORTIVA();
    int COD_DEPORTISTA = d.getCOD_DEPORTISTA();
    int COD_ROL = d.getCOD_ROL();

        //Se crea la sentencia de actualización
        String insert
                = "INSERT INTO PERSONA(COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA,"
                + " APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO,"
                + " OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA,"
                + " COD_ROL) VALUES ( "+ COD_PERSONA +", "+ COD_TIPO_IDENTIFICACION +","
                + " '"+ NOMBRE_PERSONA +"', '"+ APELLIDO1 +"', '"+ APELLIDO2 +"',"
                + " "+ COD_PROVINCIA +", "+ COD_CANTON +", "+ COD_DISTRITO +","
                + " "+ COD_BARRIO +", '"+ OTRAS_SENAS +"', '"+ DSC_CORREO +"', '"+ CONTRASENA +"',"
                + " "+ COD_DISCIPLINA_DEPORTIVA +", "+ COD_DEPORTISTA +" , "+ COD_ROL +" );";
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(insert);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
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
        String COD_DEPORTISTA = "null";
        int COD_ROL = d.getCOD_ROL();

        //Se crea la sentencia de actualización
        String insert
                = "INSERT INTO PERSONA(COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA,"
                + " APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO,"
                + " OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA,"
                + " COD_ROL) VALUES ( " + COD_PERSONA + ", " + COD_TIPO_IDENTIFICACION + ","
                + " '" + NOMBRE_PERSONA + "', '" + APELLIDO1 + "', '" + APELLIDO2 + "',"
                + " " + COD_PROVINCIA + ", " + COD_CANTON + ", " + COD_DISTRITO + ","
                + " " + COD_BARRIO + ", '" + OTRAS_SENAS + "', '" + DSC_CORREO + "', '" + CONTRASENA + "',"
                + " " + COD_DISCIPLINA_DEPORTIVA + ", " + COD_DEPORTISTA + " , " + COD_ROL + " );";
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(insert);

    }

//    Metodo buscar usuario
    public Persona loginPersona(String login, String password) throws SNMPExceptions {
        String select;
        Persona oPersona = null;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * FROM PERSONA WHERE COD_PERSONA='" + login + "' AND CONTRASENA='" + password + "' ";

            //Se ejecuta la sentencia SQL
            ResultSet d = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (d.next()) {

                //Datos de CLiente
                int COD_PERSONA = d.getInt("COD_PERSONA");
                int COD_TIPO_IDENTIFICACION = d.getInt("COD_TIPO_IDENTIFICACION");
                String NOMBRE_PERSONA = d.getString("NOMBRE_PERSONA");
                String APELLIDO1 = d.getString("APELLIDO1");
                String APELLIDO2 = d.getString("APELLIDO2");
                float COD_PROVINCIA = d.getFloat("COD_PROVINCIA");
                float COD_CANTON = d.getFloat("COD_CANTON");
                float COD_DISTRITO = d.getFloat("COD_DISTRITO");
                float COD_BARRIO = d.getFloat("COD_BARRIO");
                String OTRAS_SENAS = d.getString("OTRAS_SENAS");
                String DSC_CORREO = d.getString("DSC_CORREO");
                String CONTRASENA = d.getString("CONTRASENA");
                int COD_DISCIPLINA_DEPORTIVA = d.getInt("COD_DISCIPLINA_DEPORTIVA");
                int COD_DEPORTISTA = d.getInt("COD_DEPORTISTA");
                int COD_ROL = d.getInt("COD_ROL");

                oPersona = new Persona(COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA,
                        APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO,
                        OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA, COD_ROL);

            }
            d.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

        return oPersona;
    }

    //Metodo consultar persona void
    public static boolean consultaPersona(int id) throws SNMPExceptions {

        String select;
        Boolean resultado = false;
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "SELECT COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA, APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO, OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA, COD_ROL FROM PERSONA WHERE COD_PERSONA='" + id + "'; ";

            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se ejecuta la sentencia sql

            while (rsPA.next()) {

                resultado = true;

            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (SNMPExceptions | ClassNotFoundException | NamingException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return resultado;
    }

    //Metodo buscar persona
    public Persona buscarPersona(int id) throws SNMPExceptions, SQLException {

        String select;
        Persona resultado = new Persona();
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "SELECT COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA, APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO, OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA, COD_ROL FROM PERSONA WHERE COD_PERSONA='" + id + "'; ";

            ResultSet d = accesoDatos.ejecutaSQLRetornaRS(select);
            //se ejecuta la sentencia sql

            while (d.next()) {

                int COD_PERSONA = d.getInt("COD_PERSONA");
                int COD_TIPO_IDENTIFICACION = d.getInt("COD_TIPO_IDENTIFICACION");
                String NOMBRE_PERSONA = d.getString("NOMBRE_PERSONA");
                String APELLIDO1 = d.getString("APELLIDO1");
                String APELLIDO2 = d.getString("APELLIDO2");
                float COD_PROVINCIA = d.getFloat("COD_PROVINCIA");
                float COD_CANTON = d.getFloat("COD_CANTON");
                float COD_DISTRITO = d.getFloat("COD_DISTRITO");
                float COD_BARRIO = d.getFloat("COD_BARRIO");
                String OTRAS_SENAS = d.getString("OTRAS_SENAS");
                String DSC_CORREO = d.getString("DSC_CORREO");
                String CONTRASENA = d.getString("CONTRASENA");
                int COD_DISCIPLINA_DEPORTIVA = d.getInt("COD_DISCIPLINA_DEPORTIVA");
                int COD_DEPORTISTA = d.getInt("COD_DEPORTISTA");
                int COD_ROL = d.getInt("COD_ROL");

                Persona oPersona = new Persona(COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA,
                        APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO,
                        OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA, COD_ROL);
                resultado = oPersona;

            }
            d.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (SNMPExceptions | ClassNotFoundException | NamingException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return resultado;
    }

    //Metodo para recuperar a todos los usuarios
    public LinkedList<Persona> todoPersona() throws SNMPExceptions, SQLException {
        String select;
        LinkedList<Persona> listaPro = new LinkedList<Persona>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA, APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO, OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA, COD_ROL FROM PERSONA; ";

            //Se ejecuta la sentencia SQL
            ResultSet d = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (d.next()) {

                int COD_PERSONA = d.getInt("COD_PERSONA");
                int COD_TIPO_IDENTIFICACION = d.getInt("COD_TIPO_IDENTIFICACION");
                String NOMBRE_PERSONA = d.getString("NOMBRE_PERSONA");
                String APELLIDO1 = d.getString("APELLIDO1");
                String APELLIDO2 = d.getString("APELLIDO2");
                float COD_PROVINCIA = d.getFloat("COD_PROVINCIA");
                float COD_CANTON = d.getFloat("COD_CANTON");
                float COD_DISTRITO = d.getFloat("COD_DISTRITO");
                float COD_BARRIO = d.getFloat("COD_BARRIO");
                String OTRAS_SENAS = d.getString("OTRAS_SENAS");
                String DSC_CORREO = d.getString("DSC_CORREO");
                String CONTRASENA = d.getString("CONTRASENA");
                int COD_DISCIPLINA_DEPORTIVA = d.getInt("COD_DISCIPLINA_DEPORTIVA");
                int COD_DEPORTISTA = d.getInt("COD_DEPORTISTA");
                int COD_ROL = d.getInt("COD_ROL");

                Persona oPersona = new Persona(COD_PERSONA, COD_TIPO_IDENTIFICACION, NOMBRE_PERSONA,
                        APELLIDO1, APELLIDO2, COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO,
                        OTRAS_SENAS, DSC_CORREO, CONTRASENA, COD_DISCIPLINA_DEPORTIVA, COD_DEPORTISTA, COD_ROL);

                listaPro.add(oPersona);
            }
            d.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (SNMPExceptions | ClassNotFoundException | NamingException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return listaPro;
    }

    //Metodo cambiar contrasena
    public void cambiarContrasena(int id, String contrasena) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        String select;

        //Se intancia la clase de acceso a datos
        AccesoDatos accesoDatos = new AccesoDatos();

        //Se crea la sentencia de Busqueda
        select
                = "UPDATE PERSONA"
                + " SET CONTRASENA=" + contrasena + " "
                + "WHERE COD_PERSONA='" + id + "' ; ";

        accesoDatos.ejecutaSQL(select);
        //se ejecuta la sentencia sql

    }
}

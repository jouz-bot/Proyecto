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

public class AsignacionDeportistaInstructorDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<AsignacionDeportistaInstructor> listaP = new LinkedList<AsignacionDeportistaInstructor>();

    public AsignacionDeportistaInstructorDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public AsignacionDeportistaInstructorDB() {
        super();
    }

    public void guardarDeportista(AsignacionDeportistaInstructor pAsignacion) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        //Se obtienen los valores del objeto Cliente
        AsignacionDeportistaInstructor asi_De_Ins = new AsignacionDeportistaInstructor();
        asi_De_Ins = pAsignacion;

        //Datos de la clase
        int COD_PERSONA = asi_De_Ins.getCOD_PERSONA();
        int COD_DEPORTISTA = asi_De_Ins.getCOD_DEPORTISTA();

        //Se crea la sentencia de actualización
        String insert
                = "insert into ASIGNACION_DEPORTISTA_INSTRUCTOR (COD_PERSONA, COD_DEPORTISTA) \n"
                + "values( " + COD_PERSONA + ", " + COD_DEPORTISTA + " );";
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(insert);

    }

    public LinkedList<vistaDeportista> tablaAsigDeportista() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<vistaDeportista> listaDepo = new LinkedList<vistaDeportista>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT        PERSONA.NOMBRE_PERSONA, PERSONA.APELLIDO1, DEPORTISTA.COD_DEPORTISTA, DEPORTISTA.COD_PERSONA, DISCIPLINA_DEPORTIVA.DSC_DISPLINA_DEPORTIVA, PROVINCIAS.DSC_PROVINCIA, \n"
                    + "CANTONES.DSC_CANTON, DISTRITOS.DSC_DISTRITO\n"
                    + "FROM            PERSONA INNER JOIN\n"
                    + " DEPORTISTA ON  PERSONA.COD_PERSONA = DEPORTISTA.COD_PERSONA INNER JOIN\n"
                    + " DISCIPLINA_DEPORTIVA ON PERSONA.COD_DISCIPLINA_DEPORTIVA = DISCIPLINA_DEPORTIVA.COD_DISCIPLINA_DEPORTIVA INNER JOIN\n"
                    + " PROVINCIAS ON PERSONA.COD_PROVINCIA = PROVINCIAS.COD_PROVINCIA INNER JOIN\n"
                    + " CANTONES ON PERSONA.COD_CANTON = CANTONES.COD_CANTON AND PERSONA.COD_PROVINCIA = CANTONES.COD_PROVINCIA INNER JOIN\n"
                    + "  DISTRITOS ON PERSONA.COD_DISTRITO = DISTRITOS.COD_DISTRITO AND PERSONA.COD_CANTON = DISTRITOS.COD_CANTON AND PERSONA.COD_PROVINCIA = DISTRITOS.COD_PROVINCIA";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                String NOMBRE_PERSONA = rsPA.getString("NOMBRE_PERSONA");
                String APELLIDO1 = rsPA.getString("APELLIDO1");
                int COD_DEPORTISTA = rsPA.getInt("COD_DEPORTISTA");
                int COD_PERSONA = rsPA.getInt("COD_PERSONA");
                String DSC_DISPLINA_DEPORTIVA = rsPA.getString("DSC_DISPLINA_DEPORTIVA");
                String DSC_PROVINCIA = rsPA.getString("DSC_PROVINCIA");
                String DSC_CANTON = rsPA.getString("DSC_CANTON");
                String DSC_DISTRITO = rsPA.getString("DSC_DISTRITO");

                vistaDeportista pDeportista = new vistaDeportista(NOMBRE_PERSONA, APELLIDO1, COD_DEPORTISTA, COD_PERSONA,
                        DSC_DISPLINA_DEPORTIVA, DSC_PROVINCIA, DSC_CANTON, DSC_DISTRITO);
                listaDepo.add(pDeportista);
            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return listaDepo;
    }

    public LinkedList<vistaDeportista> tablaAsigInstructor() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<vistaDeportista> listaDepo = new LinkedList<vistaDeportista>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT        PERSONA.COD_PERSONA, PERSONA.NOMBRE_PERSONA, PERSONA.APELLIDO1, DISCIPLINA_DEPORTIVA.DSC_DISPLINA_DEPORTIVA, PROVINCIAS.DSC_PROVINCIA, CANTONES.DSC_CANTON, \n"
                    + "DISTRITOS.DSC_DISTRITO\n"
                    + "FROM PERSONA left JOIN\n"
                    + " DEPORTISTA ON  PERSONA.COD_PERSONA = DEPORTISTA.COD_PERSONA INNER JOIN\n"
                    + "DISCIPLINA_DEPORTIVA ON PERSONA.COD_DISCIPLINA_DEPORTIVA = DISCIPLINA_DEPORTIVA.COD_DISCIPLINA_DEPORTIVA INNER JOIN\n"
                    + "PROVINCIAS ON PERSONA.COD_PROVINCIA = PROVINCIAS.COD_PROVINCIA INNER JOIN\n"
                    + "CANTONES ON PERSONA.COD_CANTON = CANTONES.COD_CANTON AND PERSONA.COD_PROVINCIA = CANTONES.COD_PROVINCIA INNER JOIN\n"
                    + "DISTRITOS ON PERSONA.COD_DISTRITO = DISTRITOS.COD_DISTRITO AND PERSONA.COD_CANTON = DISTRITOS.COD_CANTON AND PERSONA.COD_PROVINCIA = DISTRITOS.COD_PROVINCIA\n"
                    + "where DEPORTISTA.COD_PERSONA is null";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                String NOMBRE_PERSONA = rsPA.getString("NOMBRE_PERSONA");
                String APELLIDO1 = rsPA.getString("APELLIDO1");
                int COD_PERSONA = rsPA.getInt("COD_PERSONA");
                String DSC_DISPLINA_DEPORTIVA = rsPA.getString("DSC_DISPLINA_DEPORTIVA");
                String DSC_PROVINCIA = rsPA.getString("DSC_PROVINCIA");
                String DSC_CANTON = rsPA.getString("DSC_CANTON");
                String DSC_DISTRITO = rsPA.getString("DSC_DISTRITO");

                vistaDeportista pDeportista = new vistaDeportista(NOMBRE_PERSONA, APELLIDO1, COD_PERSONA,
                        DSC_DISPLINA_DEPORTIVA, DSC_PROVINCIA, DSC_CANTON, DSC_DISTRITO);
                listaDepo.add(pDeportista);
            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return listaDepo;
    }

    public LinkedList<vistaDeportista> tablaFiltroAsigInstructor(String prov, String can, String dis) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<vistaDeportista> listaDepo = new LinkedList<vistaDeportista>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT PERSONA.COD_PERSONA, PERSONA.NOMBRE_PERSONA, PERSONA.APELLIDO1, DISCIPLINA_DEPORTIVA.DSC_DISPLINA_DEPORTIVA, PROVINCIAS.DSC_PROVINCIA, CANTONES.DSC_CANTON, \n"
                    + " DISTRITOS.DSC_DISTRITO\n"
                    + "FROM PERSONA left JOIN\n"
                    + " DEPORTISTA ON  PERSONA.COD_PERSONA = DEPORTISTA.COD_PERSONA INNER JOIN\n"
                    + "DISCIPLINA_DEPORTIVA ON PERSONA.COD_DISCIPLINA_DEPORTIVA = DISCIPLINA_DEPORTIVA.COD_DISCIPLINA_DEPORTIVA INNER JOIN\n"
                    + " PROVINCIAS ON PERSONA.COD_PROVINCIA = PROVINCIAS.COD_PROVINCIA INNER JOIN\n"
                    + "CANTONES ON PERSONA.COD_CANTON = CANTONES.COD_CANTON AND PERSONA.COD_PROVINCIA = CANTONES.COD_PROVINCIA INNER JOIN\n"
                    + "DISTRITOS ON PERSONA.COD_DISTRITO = DISTRITOS.COD_DISTRITO AND PERSONA.COD_CANTON = DISTRITOS.COD_CANTON AND PERSONA.COD_PROVINCIA = DISTRITOS.COD_PROVINCIA\n"
                    + "where DEPORTISTA.COD_PERSONA is null and provincias.DSC_PROVINCIA= '"+prov+"' and CANTONES.DSC_CANTON = '"+can+"'"
                    +"and DISCIPLINA_DEPORTIVA.DSC_DISPLINA_DEPORTIVA = '"+dis+"';";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                String NOMBRE_PERSONA = rsPA.getString("NOMBRE_PERSONA");
                String APELLIDO1 = rsPA.getString("APELLIDO1");
                int COD_PERSONA = rsPA.getInt("COD_PERSONA");
                String DSC_DISPLINA_DEPORTIVA = rsPA.getString("DSC_DISPLINA_DEPORTIVA");
                String DSC_PROVINCIA = rsPA.getString("DSC_PROVINCIA");
                String DSC_CANTON = rsPA.getString("DSC_CANTON");
                String DSC_DISTRITO = rsPA.getString("DSC_DISTRITO");

                vistaDeportista pDeportista = new vistaDeportista(NOMBRE_PERSONA, APELLIDO1, COD_PERSONA,
                        DSC_DISPLINA_DEPORTIVA, DSC_PROVINCIA, DSC_CANTON, DSC_DISTRITO);
                listaDepo.add(pDeportista);
            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
        return listaDepo;
    }

}

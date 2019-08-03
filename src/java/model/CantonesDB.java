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

/**
 *
 * @author Jose_Cespedes
 */
public class CantonesDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<Cantones> listaP = new LinkedList<Cantones>();

    public CantonesDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public CantonesDB() {
        super();
    }

    public Cantones buscarcanton(float pCOD_CANTON, float pCOD_PROVINCIA) throws SNMPExceptions {
        String select = "";
        Cantones perCanton = null;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * FROM CANTONES WHERE COD_CANTON='"+ pCOD_CANTON +"' AND COD_PROVINCIA='"+ pCOD_PROVINCIA +"' ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float idPro = rsPA.getFloat("COD_PROVINCIA");
                float idCanton = rsPA.getFloat("COD_CANTON");
                String nombrecanton = rsPA.getString("DSC_CANTON");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                perCanton = new Cantones(idPro, idCanton, nombrecanton, logActivo);

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

        return perCanton;
    }

    public LinkedList<Cantones> seleccionarCantonesPorProvincia(float pCOD_PROVINCIA) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Cantones> listaCan = new LinkedList<Cantones>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,COD_CANTON,"
                    + "DSC_CANTON,LOG_ACTIVO FROM CANTONES WHERE COD_PROVINCIA = '" + pCOD_PROVINCIA + "' ";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float idPro = rsPA.getFloat("COD_PROVINCIA");
                float idCanton = rsPA.getFloat("COD_CANTON");
                String nombrecanton = rsPA.getString("DSC_CANTON");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                Cantones perCanton = new Cantones(idPro, idCanton, nombrecanton, logActivo);
                listaCan.add(perCanton);
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
        return listaCan;
    }
}

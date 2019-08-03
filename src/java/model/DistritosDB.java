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
public class DistritosDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<Distritos> listaP = new LinkedList<Distritos>();

    public DistritosDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public DistritosDB() {
        super();
    }

    public Distritos buscarDistrito(float pIdDistrito, float pIdCanton, float pIdProvincia) throws SNMPExceptions {
        String select;
        Distritos oDistrito = null;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * FROM DISTRITOS WHERE COD_DISTRITO= '"+ pIdDistrito +"' AND COD_CANTON= '"+ pIdCanton +"' AND COD_PROVINCIA= '" + pIdProvincia + "' ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float idPro = rsPA.getFloat("COD_PROVINCIA");
                float idCanton = rsPA.getFloat("COD_CANTON");
                float idDistrito = rsPA.getFloat("COD_DISTRITO");
                String nombreDistrito = rsPA.getString("DSC_DISTRITO");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                oDistrito = new Distritos(idPro, idCanton, idDistrito, nombreDistrito, logActivo);

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

        return oDistrito;
    }

    public LinkedList<Distritos> seleccionarDistritoPorCanton(float pidProvincia, float pidCanton) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Distritos> listaDis = new LinkedList<Distritos>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,COD_CANTON,COD_DISTRITO,DSC_DISTRITO,LOG_ACTIVO FROM DISTRITOS WHERE COD_PROVINCIA='" + pidProvincia + "' AND "
                    + " COD_CANTON='" + pidCanton + "'";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float idPro = rsPA.getFloat("COD_PROVINCIA");
                float idCan = rsPA.getFloat("COD_CANTON");
                float idDistrito = rsPA.getFloat("COD_DISTRITO");
                String nombreDistrito = rsPA.getString("DSC_DISTRITO");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                Distritos oDistrito = new Distritos(idPro, idCan, idDistrito, nombreDistrito, logActivo);

                listaDis.add(oDistrito);
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

        return listaDis;
    }

}

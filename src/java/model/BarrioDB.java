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
public class BarrioDB {
  private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<Barrio> listaP = new LinkedList<Barrio>();

    public BarrioDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public BarrioDB() {
        super();
    }

    public Barrio buscarBarrio(float pIdDistrito, float pIdCanton, float pIdProvincia, float pIdBarrio) throws SNMPExceptions {
        String select;
        Barrio oBarrio = null;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * FROM BARRIO WHERE COD_DISTRITO= '"+ pIdDistrito +"' AND COD_CANTON= '"+ pIdCanton +"' AND COD_PROVINCIA= '" + pIdProvincia + "' AND COD_BARRIO= '"+ pIdBarrio +"' ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float idPro = rsPA.getFloat("COD_PROVINCIA");
                float idCanton = rsPA.getFloat("COD_CANTON");
                float idDistrito = rsPA.getFloat("COD_DISTRITO");
                float idBarrio = rsPA.getFloat("COD_BARRIO");
                String nombreBarrio = rsPA.getString("DSC_BARRIO");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                oBarrio = new Barrio(idPro, idCanton, idDistrito, idBarrio, nombreBarrio, logActivo);

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

        return oBarrio;
    }

    public LinkedList<Barrio> seleccionarBarrioPorDistrito(float pidProvincia, float pidCanton, float pidDistrito) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Barrio> listaDis = new LinkedList<Barrio>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,COD_CANTON,COD_DISTRITO,COD_BARRIO,DSC_BARRIO,LOG_ACTIVO FROM BARRIO WHERE COD_PROVINCIA='" + pidProvincia + "' AND "
                    + " COD_CANTON='" + pidCanton + "' AND COD_DISTRITO='"+ pidDistrito +"' ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float idPro = rsPA.getFloat("COD_PROVINCIA");
                float idCan = rsPA.getFloat("COD_CANTON");
                float idDistrito = rsPA.getFloat("COD_DISTRITO");
                float idBarrio = rsPA.getFloat("COD_BARRIO");
                String nombreBarrio = rsPA.getString("DSC_BARRIO");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                Barrio oBarrio = new Barrio(idPro, idCan, idDistrito, idBarrio, nombreBarrio, logActivo);

                listaDis.add(oBarrio);
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

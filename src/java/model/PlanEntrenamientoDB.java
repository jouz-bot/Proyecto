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
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

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

    public LinkedList<PlanEntrenamiento> ComboPlan() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<PlanEntrenamiento> listaPlan = new LinkedList<PlanEntrenamiento>();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "select COD_PLAN_ENTRENAMIENTO, COD_PERIOCIDAD, FECHA_INICIO, FECHA_FIN, "
                    + "COD_ACTIVIDAD_FISICA, DSC_PLAN_ENTRENAMIENTO, DURACION,REPETICIONES, "
                    + "COD_ASIGNACION_DEPORTISTA_INSTRUCTOR from PLAN_ENTRENAMIENTO";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                int COD_PLAN_ENTRENAMIENTO = rsPA.getInt("COD_PLAN_ENTRENAMIENTO");
                int COD_PERIOCIDAD = rsPA.getInt("COD_PERIOCIDAD");
                Date FECHA_INICIO = rsPA.getDate("FECHA_INICIO");
                Date FECHA_FIN = rsPA.getDate("FECHA_FIN");
                int COD_ACTIVIDAD_FISICA = rsPA.getInt("COD_ACTIVIDAD_FISICA");
                String DSC_PLAN_ENTRENAMIENTO = rsPA.getString("DSC_PLAN_ENTRENAMIENTO");
                String DURACION = rsPA.getString("DURACION");
                int REPETICIONES = rsPA.getInt("REPETICIONES");
                int COD_ASIGNACION_DEPORTISTA_INSTRUCTOR = rsPA.getInt("COD_ASIGNACION_DEPORTISTA_INSTRUCTOR");

                //se construye el objeto.
                PlanEntrenamiento perCandidato = new PlanEntrenamiento(COD_PLAN_ENTRENAMIENTO, COD_PERIOCIDAD, FECHA_INICIO,
                        FECHA_FIN, COD_ACTIVIDAD_FISICA, DSC_PLAN_ENTRENAMIENTO, DURACION,
                        REPETICIONES, COD_ASIGNACION_DEPORTISTA_INSTRUCTOR);

                listaPlan.add(perCandidato);
            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (SNMPExceptions | ClassNotFoundException | NamingException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return listaPlan;
    }

}

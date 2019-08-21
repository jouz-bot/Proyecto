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
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Jose_Cespedes
 */
public class RegistroActividadDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<RegistroActividad> listaP = new LinkedList<RegistroActividad>();

    public RegistroActividadDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public RegistroActividadDB() {
        super();
    }

    public void guardarRegistroActividad(RegistroActividad pRegistro) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        //Se obtienen los valores del objeto Cliente
        RegistroActividad actividad = new RegistroActividad();
        actividad = pRegistro;

        //Datos de la clase
        Date FECHA_ACTIVIDAD = actividad.getFECHA_ACTIVIDAD();
        String TIEMPO = actividad.getTIEMPO();
        int REPETICIONES = actividad.getREPETICIONES();
//        int COD_ACTIVIDAD_FISICA = actividad.getCOD_ACTIVIDAD_FISICA();
        int COD_PLAN_ENTRENAMIENTO = actividad.getCOD_PLAN_ENTRENAMIENTO();

        //Se crea la sentencia de actualización
        String insert
                = "insert into REGISTRO_ACTIVIDAD(FECHA_REGISTRO, FECHA_ACTIVIDAD, TIEMPO, REPETICIONES, COD_ACTIVIDAD_FISICA, COD_PLAN_ENTRENAMIENTO)\n"
                + "values(GETDATE(), "
                + FECHA_ACTIVIDAD + ","
                + "'" + TIEMPO + "',"
                + REPETICIONES + ","
                + 1 + ","
                + COD_PLAN_ENTRENAMIENTO + ")";
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(insert);

    }

}

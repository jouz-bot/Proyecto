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
public class ContrasenaPersonaDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<Cantones> listaP = new LinkedList<Cantones>();

    public ContrasenaPersonaDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public ContrasenaPersonaDB() {
        super();
    }

    public ContrasenaPersona buscarContrasena(int pCOD_PERSONA) throws SNMPExceptions {
        String select = "";
        ContrasenaPersona perCanton = null;

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * FROM CONTRASENA _PERSONA WHERE COD_PERSONA='" + pCOD_PERSONA + "' ";

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int idPersona = rsPA.getInt("COD_PERSONA");
                String contrasena = rsPA.getString("DSC_CONTRESANA");
                Date fecha = rsPA.getDate("FECHA");
                int activo = rsPA.getInt("ACTIVO");
             

                perCanton = new ContrasenaPersona(idPersona, contrasena, fecha, activo);

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

    public LinkedList<ContrasenaPersona> seleccionarContrasenaPorPersona(int pCOD_PERSONA) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<ContrasenaPersona> listaCan = new LinkedList<ContrasenaPersona>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PERSONA,DSC_CONTRESANA,"
                    + "FECHA,ACTIVO FROM CONTRASENA_PERSONA WHERE COD_PERSONA = '" + pCOD_PERSONA + "' ";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int idPersona = rsPA.getInt("COD_PERSONA");
                String contrasena = rsPA.getString("DSC_CONTRESANA");
                Date fecha = rsPA.getDate("FECHA");
                int activo = rsPA.getInt("ACTIVO");

                ContrasenaPersona perCanton = new ContrasenaPersona(idPersona, contrasena, fecha, activo);
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

        public void guardarContrasena(ContrasenaPersona votoC) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        //Se obtienen los valores del objeto Cliente
       ContrasenaPersona d = new ContrasenaPersona();
        d = votoC;

        //Datos de CLiente
            int idPersona = d.getCOD_PERSONA();
            String contrasena = d.getDSC_CONTRESANA();
            Date fecha = d.getFECHA();
            int activo = d.getACTIVO();

        //Se crea la sentencia de actualización
        String insert
                = "INSERT INTO CONTRASENA_PERSONA(COD_PERSONA, DSC_CONTRESANA, FECHA, ACTIVO) VALUES ("
                + " '" + idPersona + "', '" + contrasena + "', " + null + ", '" + activo + "')";
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(insert);
    }
}

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
public class ProvinciasDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;  

    private LinkedList<Provincias> listaP = new LinkedList<Provincias>();
    
    public ProvinciasDB (Connection conn) {
        accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
    }
    
    public ProvinciasDB() {
        super();
    }
    
    public LinkedList<Provincias> moTodo() throws SNMPExceptions, 
            SQLException {
      String select = "";
      LinkedList<Provincias> listaPro = new LinkedList<Provincias>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT COD_PROVINCIA,DSC_CORTA_PROVINCIA,"
                      + "DSC_PROVINCIA,LOG_ACTIVO FROM Provincias";
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                String dscCortaProvincia = rsPA.getString(""
                        + "DSC_CORTA_PROVINCIA");
                String dscProvincia = rsPA.getString("DSC_PROVINCIA");
                int logActivo= rsPA.getInt("LOG_ACTIVO");
                
                Provincias perProvincia = new Provincias(codigoProvincia, 
                            dscCortaProvincia, dscProvincia,logActivo);
                listaPro.add(perProvincia);
              }
              rsPA.close();
              
          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          return listaPro;
      }
    
        //Definicion atributo
    Provincias provincias;
    
    //Metodos SET y GET

    public Provincias getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }
    
}

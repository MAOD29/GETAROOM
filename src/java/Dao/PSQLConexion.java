/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelolea
 */
public class PSQLConexion {
    
    Connection conectar()  {
       Connection conexion = null;
       String url = "jdbc:postgresql://127.0.0.1/getaroom";
       Properties propiedades = new Properties();
       propiedades.setProperty("user","postgres");
       propiedades.setProperty("password","12345");
       
       try{
          Class.forName("org.postgresql.Driver"); 
           conexion = DriverManager.getConnection(url,propiedades);
           System.out.println("si conecta");
           
       }catch (SQLException sqle){
           System.out.println(sqle.getMessage());
           System.out.println("nooooo");
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(PSQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
        
    }
    
    
    
}

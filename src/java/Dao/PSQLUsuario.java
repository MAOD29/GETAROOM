/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Models.Usuario;
import Utilities.excepcionbasededatos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelolea
 */
public class PSQLUsuario {
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    
    private final String INSERTAR = "insert into usuarios (nombre,apellidos,email,telefono,password,admin)"
                                    + " values(?,?,?,?,md5(?),?) RETURNING id ";
    private final String MODIFICAR = "UPDATE usuarios SET usuario = ?, "
                                   + "SET nombre = ?,apellidos = ?,email = ?,telefono = ?,password = md5(?) WHERE id = ? ";
    private final String BuscarTodos = "SELECT * FROM usuarios";
    private final String getxid ="SELECT * From usuarios WHERE id = ?";
    private final String getOne = "SELECT * From usuarios WHERE email = ? AND password = ?";
   
    
    
    public void insertar(Usuario user) throws excepcionbasededatos, ClassNotFoundException  {
      try {
          conexion = new PSQLConexion().conectar();
          
          sentencia = conexion.prepareStatement(INSERTAR);
          sentencia.setString(1, user.getNombre());
          sentencia.setString(2, user.getApellidos());
          sentencia.setString(3, user.getEmail());
          sentencia.setString(4, user.getTelefono());
          sentencia.setString(5, user.getPassword());
          sentencia.setBoolean(6, user.isAdmin());

          resultados = sentencia.executeQuery();
          if(resultados.next()){
              user.setId(resultados.getInt(1));
          }else {
              throw new excepcionbasededatos("no se inserto");
          }
          
      }catch(SQLException sqle){
          System.out.println(sqle.getMessage());
      }
    }

    public void modificar(Usuario o) {
        
    }


    public void eliminar(Usuario o) {
 
    }

  
    public void buscarporid(Usuario user) {
        try{
            conexion = new PSQLConexion().conectar();
            sentencia = conexion.prepareStatement(getxid);
            sentencia.setInt(1, user.getId());
            resultados = sentencia.executeQuery();
            if(resultados.next()){
               
                user.setId(resultados.getInt("id"));
                user.setNombre(resultados.getString("nombre"));
                user.setApellidos(resultados.getString("apellidos"));
                user.setEmail(resultados.getString("email"));
                user.setTelefono(resultados.getString("telefono"));
                user.setPassword(resultados.getString("password"));
                user.setAdmin(resultados.getBoolean("admin"));
                System.out.println(user.getNombre());
               
            }
        }catch(SQLException sqle){
             System.out.println(sqle.getMessage());
        }finally{
           cerrarconexiones();
        }
      
         
    }

    public boolean login(Usuario user){
        try {
          conexion = new PSQLConexion().conectar();
          sentencia = conexion.prepareStatement(getOne);
          sentencia.setString(1, user.getEmail());
          sentencia.setString(2, user.getPassword());
          resultados = sentencia.executeQuery();
          if(resultados.next()){
              return true;
          }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
          
        } finally{
         cerrarconexiones();
      }
        return false;
    }
    public List<Usuario> obtenerTodos(){
        
        List list = new ArrayList();
        
         try {
          conexion = new PSQLConexion().conectar();
          sentencia = conexion.prepareStatement(BuscarTodos);
          resultados = sentencia.executeQuery();
            
          while(resultados.next()){
             Usuario usuario = new Usuario();
             usuario.setId(resultados.getInt("id"));
             usuario.setNombre(resultados.getString("nombre"));
             usuario.setApellidos(resultados.getString("apellidos"));
             usuario.setEmail(resultados.getString("email"));
             usuario.setTelefono(resultados.getString("telefono"));
             usuario.setPassword(resultados.getString("password"));

            list.add(usuario);
             
          }
          
      }catch(SQLException sqle){
          System.out.println(sqle.getMessage());
      }finally{
         cerrarconexiones();
      }
         return list;
    }
    
    private void cerrarconexiones(){
        try {

            if(resultados != null){
                resultados.close();
            }
            if(sentencia != null){
                sentencia.close();
            }
            if(conexion != null) {
                conexion.close();
            }
            System.out.println("conexiones cerradas");
        
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
         }
        
        
    }
    
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author miguelolea
 */
public class excepcionbasededatos extends RuntimeException{
    
    public excepcionbasededatos(){
        System.out.println("ocurrio un error de consulta a la base de datos");
    }
    
    
    public excepcionbasededatos(String mensaje){
        super(mensaje);
    }
    
    
}

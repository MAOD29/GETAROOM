/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miguelolea
 */
public class Utilities {
     public static void irApagina(HttpServletRequest request,HttpServletResponse response,
                                ServletContext contexto, String direccion) 
                                throws ServletException, IOException, IllegalStateException{
        
         RequestDispatcher despachador = contexto.getRequestDispatcher(direccion);
        despachador.forward(request,response); 
    }
}

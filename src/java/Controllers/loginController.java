/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.PSQLUsuario;
import Models.Usuario;
import Utilities.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miguelolea
 */
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //To change body of generated methods, choose Tools | Templates.
        Utilities.irApagina(request, response, getServletContext(), "/login.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       Usuario usuario = new Usuario();
       usuario.setEmail(email);
       usuario.setPassword(password);
       
        PSQLUsuario postgres = new PSQLUsuario(); 
        boolean status = postgres.login(usuario);
      
        if(status){
            String sesion = "tiene permiso";
            HttpSession session = request.getSession();
            session.setAttribute("sesion", sesion);
            response.sendRedirect("/GETAROOM/views/admin.jsp");
            //Utilities.irApagina(request, response, getServletContext(), "/usuarios");
            
        
        }else{
            System.out.println("no entro");
            String msg = "no tiene persimo";
            request.setAttribute("msg", msg);
            Utilities.irApagina(request, response, getServletContext(), "/login.jsp");
            
        }
    }
    


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

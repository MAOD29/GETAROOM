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
import java.util.List;
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
public class UsuariosController extends HttpServlet {

  
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String page = request.getParameter("page");
        
        if(session.getAttribute("sesion") == null){
            String msg = "no tiene persimo";
            request.setAttribute("msg", msg);
            Utilities.irApagina(request, response, getServletContext(), "/login.jsp");
            System.out.println(session);
        }
        
        if(page == null){
            PSQLUsuario postgres = new PSQLUsuario();
            List<Usuario> usuarios =  postgres.obtenerTodos();
            request.setAttribute("usuarios", usuarios);
            Utilities.irApagina(request, response, getServletContext(), "/views/usuarios/index.jsp");

        }else if(page.equals("edit")){
            String sid =  request.getParameter("id");
            int id = Integer.parseInt(sid);
            PSQLUsuario postgres = new PSQLUsuario();
            Usuario user = new Usuario();
            user.setId(id);
            postgres.buscarporid(user);
            
            request.setAttribute("user", user);
            Utilities.irApagina(request, response, getServletContext(), "/views/usuarios/edit.jsp");
               
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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

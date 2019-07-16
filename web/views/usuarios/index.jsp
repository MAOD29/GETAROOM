<%-- 
    Document   : index
    Created on : 8 jul 2019, 15:08:29
    Author     : miguelolea
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../../WEB-INF/layouts/headerAdmin.jsp" %>

        <h1>Todos los usuarios</h1>
        <br>
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apelidos</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Admin</th>
                    <th>Acciones</th>

                </tr>
            </thead>

            <tbody>
                <tr>
                    
                    <c:forEach var="usuario" items="${usuarios}">
                        <td>${usuario.nombre}</td>
                        <td>${usuario.apellidos}</td>
                        <td>${usuario.email}</td>
                        <td>${usuario.telefono}</td>
                        <td>${usuario.admin}</td>
                        <td>
                            <a class="btn btn-outline-primary" href="/GETAROOM/usuarios?page=edit&id=${usuario.id}">Editar</a>
                           
                        </td>
                    </c:forEach>
             </tr>   
            </tbody>

        </table>


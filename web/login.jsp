<%-- 
    Document   : login
    Created on : 12 jul 2019, 14:06:08
    Author     : miguelolea
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="WEB-INF/layouts/header.jsp" %>
<div class="container">
    
    <h1>Login</h1>
    <hr>
    <form action="/GETAROOM/login" method="POST">
    <div class="form-group">
      <label for="exampleInputEmail1">Correo Electronico</label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" 
             name="email" placeholder="Ingresar email">
      <small id="emailHelp" class="form-text text-muted">Todos la información proporcionada es de caracter privadado.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Contraseña</label>
      <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
    </div>
    <div class="form-group form-check">
      <input type="checkbox" class="form-check-input" id="exampleCheck1">
      <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
    
    <c:out value="${msg}"/>
 <hr>
</div>
    

<%@include file="WEB-INF/layouts/footer.jsp" %>

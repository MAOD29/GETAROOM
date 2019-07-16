
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../../WEB-INF/layouts/headerAdmin.jsp" %>
<h1>Editar usuario</h1>
<form action="#">  
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="nombre">Nombre</label>
      <input type="text" class="form-control" name="nombre" value="${user.nombre}" placeholder="Nombre">
    </div>
    <div class="form-group col-md-4">
      <label for="apellidos">Apellidos</label>
      <input type="text" class="form-control" id="apellidos" name="apellidos" value="${user.apellidos}"
             placeholder="Apellidos">
    </div>
    <div class="form-group col-md-4">
      <label for="email">email</label>
      <input type="email" class="form-control" id="apellidos" name="email" value="${user.email}"
             placeholder="Apellidos">
    </div>         
  </div
  <br>
 <div class="form-row">

       <div class="form-group col-md-4">
      <label for="telefono">Telefono</label>
      <input type="text" class="form-control" name="telefono" value="${user.telefono}" placeholder="Telefono">
    </div>
    <div class="form-group col-md-4">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" name="password" value="${user.password}"
             placeholder="Password">
    </div>
    <div class="form-group col-md-4">
      <label for="admin">Admin</label>
      <input type="admin" class="form-control" id="admin" name="admin" value="${user.admin}"
             placeholder="Admin">
    </div>         

  </div>
    
  <button type="submit" class="btn btn-primary btn-lg btn-block">Actualizar</button>

    
    

    
        
    
</form>
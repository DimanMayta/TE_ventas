<%
    //PROTECCION
    if (session.getAttribute("aceptado") != "OK") {//validacion diferente de ok
        response.sendRedirect("login.jsp");//enviar a login
    }
%>
<%-- 
    Document   : frmusuario
    Created on : 22 may. 2024, 15:35:09
    Author     : Diman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Punto de venta</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="usuarios"/>
        </jsp:include>
        <div class="container">
            <h1>Formulario de usuarios</h1>

            <br>
            <form action="UsuarioControlador" method="post">
                <input type="hidden" name="id" value="${usuario.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" id="nombres" value="${usuario.nombres}" placeholder="Escriba sus nombres">                   
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" id="apellidos" value="${usuario.apellidos}" placeholder="Escriba sus apellidos">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Correo electrónico</label>
                    <input type="email" class="form-control" name="correo" id="correo" value="${usuario.correo}" placeholder="Escriba su correo electrónico">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" name="password" id="password" value="${usuario.password}" placeholder="Escriba su contraseña">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>

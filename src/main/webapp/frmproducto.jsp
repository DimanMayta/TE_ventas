<%
    //PROTECCION
    if (session.getAttribute("aceptado") != "OK") {//validacion diferente de ok
        response.sendRedirect("login.jsp");//enviar a login
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frmproducto
    Created on : 22 may. 2024, 13:39:15
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
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="productos"/>
        </jsp:include>
        <div class="container">
            <h1>Formulario de productos</h1>

            <br>
            <form action="ProductoControlador" method="post">
                <input type="hidden" name="id" value="${producto.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${producto.nombre}" placeholder="Escriba el nombre del producto">                   
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Descripción</label>
                    <textarea class="form-control" name="descripcion" placeholder="Escriba la descripción del producto">${producto.descripcion}</textarea>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Precio</label>
                    <input type="text" class="form-control" name="precio" value="${producto.precio}" placeholder="Escriba el precio del producto">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>

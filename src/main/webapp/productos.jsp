<%
    //PROTECCION
    if (session.getAttribute("aceptado") != "OK") {//validacion diferente de ok
        response.sendRedirect("login.jsp");//enviar a login
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : productos
    Created on : 21 may. 2024, 19:39:18
    Author     : Diman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head><script src="https://getbootstrap.com/docs/5.3/assets/js/color-modes.js"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Punto de venta</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="META-INF/tema.jsp" />
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="productos"/>
        </jsp:include>
        <div class="container">
            <h1>Productos</h1>
            <br>
            <a href="ProductoControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-regular fa-square-plus"></i> Nuevo</a>
            <br><br>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th></th>
                    <th></th>
                </tr>

                <c:forEach var="producto" items="${productos}">
                    <tr>
                        <td>${producto.id}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.precio}</td>
                        
                        <td><a href="ProductoControlador?action=edit&id=${producto.id}"><i class="fa-solid fa-marker"></i></a></td>
                        <td><a href="ProductoControlador?action=delete&id=${producto.id}" onclick="return(confirm('¿Está seguro de eliminar este producto?'))"> <i class="fa-regular fa-trash-can" style="color: red;"></i></a></td>
                    </tr>
                </c:forEach> 
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
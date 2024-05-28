<%-- 
    Document   : index
    Created on : 21 may. 2024, 18:49:00
    Author     : Diman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Punto de venta</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Punto de venta</h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <a href="#" class="btn btn-primary btn-sm"><i class="fa-regular fa-square-plus"></i> Nuevo</a>
            <br><br>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Notebook</td>
                    <td>Compra de Notebook</td>
                    <td>1500</td>
                    <td><a href="#"><i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="#"><i class="fa-solid fa-trash-can"></i></a></td>
                </tr>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
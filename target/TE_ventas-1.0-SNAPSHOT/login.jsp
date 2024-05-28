<%-- 
    Document   : login
    Created on : 21 may. 2024, 23:15:02
    Author     : Diman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
    <head><script src="https://getbootstrap.com/docs/5.3/assets/js/color-modes.js"></script>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.122.0">
        <title>Login</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="https://getbootstrap.com/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="css/diman.css">

    </head>
    <body class="d-flex align-items-center py-4 bg-body-tertiary">
        <jsp:include page="META-INF/tema.jsp" />

        <main class="form-signin w-100 m-auto">
            <form action="LoginControlador" method="post">
                <img class="mb-4" src="https://rrnnii.upea.bo/carreras_logo/ingenieria_sistemas.png" alt="" width="80" height="80">
                <h1 class="h3 mb-3 fw-normal">Login</h1>

                <div class="form-floating">
                    <input type="email" name="correo" class="form-control" id="floatingInput" placeholder="name@ejemplo.com">
                    <label for="floatingInput">Correo electrónico</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="form-check text-start my-3">
                    <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        Recuerdame
                    </label>
                </div>
                <button class="btn btn-primary w-100 py-2" type="submit">Ingresar</button>
                <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
            </form>
        </main>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>

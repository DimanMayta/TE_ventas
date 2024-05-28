package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diman
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO dao = new UsuarioDAOimpl();
            Usuario usr = new Usuario();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("usuario", usr);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response); // formulario para adicionar usuario
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usr = dao.getById(id);
                    request.setAttribute("usuario", usr);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioControlador");//devuelve lista
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        Usuario usr = new Usuario();

        usr.setId(id);
        usr.setNombres(nombres);
        usr.setApellidos(apellidos);
        usr.setCorreo(correo);
        usr.setPassword(password);

        UsuarioDAO dao = new UsuarioDAOimpl();
        if (id == 0) { // Verificamos si es nuevo, viene con 0
            try {
                // Nuevo registro
                dao.insert(usr);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                // Edición de registro
                dao.update(usr);
            } catch (Exception ex) {
                System.out.println("Error al actualizar " + ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
    }
}

package com.emergentes.controlador;

import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diman
 */
@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
        if (action.equals("aceptado")) {
            HttpSession ses = request.getSession();
            ses.invalidate();
        }
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = md5(?)";
        ResultSet rs;
        //System.out.println("Datos.."+correo+" "+password);
        ConexionDB canal = new ConexionDB();
        Connection cn = canal.conectar();//conexion a la DB
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                //Crear las variables de session para el uso en la aplicacion
                HttpSession ses = request.getSession();
                ses.setAttribute("aceptado", "OK");
                ses.setAttribute("usuario", rs.getString("nombres") + " " + rs.getString("apellidos"));
                response.sendRedirect("ClienteControlador");//mandamos a ClienteControlador
                //System.out.println("Todo Ok");
            } else {
                //System.out.println("Incorrecto");
                response.sendRedirect("login.jsp");
            }

        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos");
        }

        /*----------METODO VALIDACION---------------------------------------------
         // veridicar los datos
        Validate v = new Validate();
        
        if(v.checkUser(correo, password)){
            //System.out.println("Todo Ok");
            HttpSession ses = request.getSession();
            ses.setAttribute("login", "OK");
            response.sendRedirect("ClienteControlador");//mandamos a ClienteControlador
        }else{
            //System.out.println("Incorrecto");
            response.sendRedirect("login.jsp");
        }
         */
    }

}

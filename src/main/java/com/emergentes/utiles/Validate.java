package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diman
 */
public class Validate extends ConexionDB {
    Connection con = this.conectar();
    PreparedStatement pr;
    
    public boolean checkUser(String email, String password){
        boolean resultado = false;
        try {
            String sql = "SELECT * FROM usuarios WHERE email=? AND password=sha1(?)";
            
            pr = con.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();//sacamos la consulta
            resultado = rs.next();

        } catch (SQLException ex) {
            System.out.println(""
                    + "Error al autentificar");
        }
        return resultado;
    }
}

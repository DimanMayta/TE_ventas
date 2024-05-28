package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diman
 */
public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO {

    @Override
    public void insert(Usuario usr) throws Exception {
        String sql = "INSERT INTO usuarios (nombres, apellidos, correo, password) VALUES (?,?,?,md5(?))";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usr.getNombres());
        ps.setString(2, usr.getApellidos());
        ps.setString(3, usr.getCorreo());
        ps.setString(4, usr.getPassword());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario usr) throws Exception {
        String sql = "UPDATE usuarios SET nombres = ?, apellidos = ?, correo = ?, password = md5(?) WHERE id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usr.getNombres());
        ps.setString(2, usr.getApellidos());
        ps.setString(3, usr.getCorreo());
        ps.setString(4, usr.getPassword());
        ps.setInt(5, usr.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usr = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usr.setId(rs.getInt("id"));
            usr.setNombres(rs.getString("nombres"));
            usr.setApellidos(rs.getString("apellidos"));
            usr.setCorreo(rs.getString("correo"));
        }
        this.desconectar();
        return usr;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;

        String sql = "SELECT * FROM usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Usuario>();

        while (rs.next()) {
            Usuario usu = new Usuario();
            usu.setId(rs.getInt("id"));
            usu.setNombres(rs.getString("nombres"));
            usu.setApellidos(rs.getString("apellidos"));
            usu.setCorreo(rs.getString("correo"));
            usu.setPassword(rs.getString("password"));
            lista.add(usu);
        }
        this.desconectar();
        return lista;
    }

}

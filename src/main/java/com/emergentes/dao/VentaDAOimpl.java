package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diman
 */
public class VentaDAOimpl extends ConexionDB implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO ventas (producto_id, cliente_id, fecha) VALUES (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setDate(3, venta.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            this.conectar();//actualizar
            String sql = "UPDATE ventas SET producto_id=?, cliente_id=?, fecha=? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setDate(3, venta.getFecha());
            ps.setInt(4, venta.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM ventas WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Venta getById(int id) throws Exception {
        Venta v = new Venta();
        try {
            this.conectar();
            String sql = "SELECT * FROM ventas WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); //almacenamos en rs-consulta seleccion
            if (rs.next()) { // si hay registro adicionar datos en el objeto (v) venta
                v.setId(rs.getInt("id"));
                v.setProducto_id(rs.getInt("producto_id"));
                v.setCliente_id(rs.getInt("cliente_id"));
                v.setFecha(rs.getDate("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return v;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;
        try {
            this.conectar();
            //Combinacion de tablas
            //objetos que muestren valores de descripcion
            String sql = "SELECT v.*,p.nombre as producto, c.nombre as cliente FROM ventas v ";
            sql += "LEFT JOIN productos p ON v.producto_id = p.id ";
            sql += "LEFT JOIN clientes c ON v.cliente_id = c.id";
            
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); // adicionamos registros a rs

            lista = new ArrayList<Venta>();//coleccion inicializada
            while (rs.next()) { // varios registros para adicionar datos en el objeto venta
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setProducto_id(rs.getInt("producto_id"));
                v.setCliente_id(rs.getInt("cliente_id"));
                v.setFecha(rs.getDate("fecha"));
                v.setCliente(rs.getString("cliente"));//adicion propiedad adicional
                v.setProducto(rs.getString("producto"));//adicion propiedad adicional
                lista.add(v);
            }
            rs.close();//cerrar rs
            ps.close();//cerrar ps
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;//devolver la lista
    }

}

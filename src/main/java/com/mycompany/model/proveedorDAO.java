package com.mycompany.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class proveedorDAO {

    // GUARDAR
    public void guardar(Proveedor p) {
        String sql = "INSERT INTO proveedor (nombre, telefono, direccion) VALUES (?, ?, ?)";

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setIdproveedor(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Error al guardar proveedor: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizar(Proveedor p) {
        String sql = "UPDATE proveedor SET nombre=?, telefono=?, direccion=? WHERE id_proveedor=?";

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.setInt(4, p.getIdproveedor());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar proveedor: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM proveedor WHERE id_proveedor=?";

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar proveedor: " + e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Proveedor buscarPorId(int id) {
        String sql = "SELECT * FROM proveedor WHERE id_proveedor=?";

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar proveedor: " + e.getMessage());
        }
        return null;
    }

    // LISTAR TODOS
    public List<Proveedor> listarTodos() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";

        try (
                Connection cn = Conexion.getConexion(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar proveedores: " + e.getMessage());
        }
        return lista;
    }

    public boolean buscarNombre(String nombre) {
        String sql = "SELECT 1 FROM proveedor WHERE nombre = ? LIMIT 1"; // solo necesitamos saber si existe
        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // true si encontró al menos un registro
            }
        } catch (SQLException e) {
            System.err.println("Error al validar nombre de proveedor: " + e.getMessage());
        }
        return false; // si hay error o no existe
    }

}

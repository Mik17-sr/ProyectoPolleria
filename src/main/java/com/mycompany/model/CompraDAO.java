package com.mycompany.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;

public class CompraDAO {

    private static final SimpleDateFormat FORMATO_FECHA
            = new SimpleDateFormat("yyyy-MM-dd");

    // GUARDAR
    public void guardar(Compra c) {
        String sql = """
            INSERT INTO compra 
            (id_proveedor, fecha_compra, precio_compra, observaciones)
            VALUES (?, ?, ?, ?)
        """;

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, c.getProveedor().getIdproveedor());
            ps.setString(2, FORMATO_FECHA.format(c.getFecha()));
            ps.setDouble(3, c.getPrecio());
            ps.setString(4, c.getObservacion());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Error al guardar compra: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizar(Compra c) {
        String sql = """
            UPDATE compra
            SET id_proveedor=?,
                fecha_compra=?,
                precio_compra=?,
                observaciones=?
            WHERE id_compra=?
        """;

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, c.getProveedor().getIdproveedor());
            ps.setString(2, FORMATO_FECHA.format(c.getFecha()));
            ps.setDouble(3, c.getPrecio());
            ps.setString(4, c.getObservacion());
            ps.setInt(5, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar compra: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(int idCompra) {
        String sql = "DELETE FROM compra WHERE id_compra=?";

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idCompra);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar compra: " + e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Compra buscarPorId(int idCompra) {
        String sql = """
            SELECT c.*, p.nombre
            FROM compra c
            JOIN proveedor p ON p.id_proveedor = c.id_proveedor
            WHERE c.id_compra=?
        """;

        try (
                Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setIdproveedor(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));

                return new Compra(
                        prov,
                        rs.getInt("id_compra"),
                        rs.getDouble("precio_compra"),
                        FORMATO_FECHA.parse(rs.getString("fecha_compra")),
                        rs.getString("observaciones")
                );
            }

        } catch (Exception e) {
            System.err.println("Error al buscar compra: " + e.getMessage());
        }
        return null;
    }

    // LISTAR TODAS
    public List<Compra> listarTodas() {
        List<Compra> lista = new ArrayList<>();

        String sql = """
            SELECT c.*, p.nombre
            FROM compra c
            JOIN proveedor p ON p.id_proveedor = c.id_proveedor
            ORDER BY fecha_compra DESC
        """;

        try (
                Connection cn = Conexion.getConexion(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setIdproveedor(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));

                Compra c = new Compra(
                        prov,
                        rs.getInt("id_compra"),
                        rs.getDouble("precio_compra"),
                        FORMATO_FECHA.parse(rs.getString("fecha_compra")),
                        rs.getString("observaciones")
                );
                lista.add(c);
            }

        } catch (Exception e) {
            System.err.println("Error al listar compras: " + e.getMessage());
        }
        return lista;
    }

    public List<Compra> listarPorAtributo(String columna, Object valor) {
        List<Compra> lista = new ArrayList<>();

        // Construimos la SQL usando el nombre de la columna dinámicamente
        // Usamos ? para el valor para que sea seguro
        String sql = "SELECT c.*, p.nombre "
                + "FROM compra c "
                + "JOIN proveedor p ON p.id_proveedor = c.id_proveedor "
                + "WHERE " + columna + " = ? "
                + "ORDER BY fecha_compra DESC";

        try (Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            // Seteamos el valor (funciona para String, Int, etc., gracias a setObject)
            ps.setObject(1, valor);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Proveedor prov = new Proveedor();
                    prov.setIdproveedor(rs.getInt("id_proveedor"));
                    prov.setNombre(rs.getString("nombre"));

                    Compra c = new Compra(
                            prov,
                            rs.getInt("id_compra"),
                            rs.getDouble("precio_compra"),
                            FORMATO_FECHA.parse(rs.getString("fecha_compra")),
                            rs.getString("observaciones")
                    );
                    lista.add(c);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al filtrar compras: " + e.getMessage());
        }
        return lista;
    }

    public List<Compra> listarPorRangoFechas(java.util.Date inicio, java.util.Date fin) {
        List<Compra> lista = new ArrayList<>();

        // SQL para SQLite comparando fechas como texto (formato yyyy-MM-dd)
        String sql = "SELECT c.*, p.nombre "
                + "FROM compra c "
                + "JOIN proveedor p ON p.id_proveedor = c.id_proveedor "
                + "WHERE c.fecha_compra BETWEEN ? AND ? "
                + "ORDER BY c.fecha_compra DESC";

        try (Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            // Convertimos las fechas de Java a String para SQLite
            ps.setString(1, FORMATO_FECHA.format(inicio));
            ps.setString(2, FORMATO_FECHA.format(fin));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // 1. Mapeamos el Proveedor
                    Proveedor prov = new Proveedor();
                    prov.setIdproveedor(rs.getInt("id_proveedor")); // Ajusta si el nombre es id_proveedor
                    prov.setNombre(rs.getString("nombre"));

                    // 2. Mapeamos la Compra
                    // Convertimos el String de la BD a Date de Java
                    java.util.Date fecha = null;
                    try {
                        String fechaStr = rs.getString("fecha_compra");
                        if (fechaStr != null) {
                            fecha = FORMATO_FECHA.parse(fechaStr);
                        }
                    } catch (Exception ex) {
                        System.err.println("Error al parsear fecha: " + ex.getMessage());
                    }

                    Compra c = new Compra(
                            prov,
                            rs.getInt("id_compra"),
                            rs.getDouble("precio_compra"),
                            fecha,
                            rs.getString("observaciones")
                    );

                    lista.add(c);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al listar compras por rango en SQLite: " + e.getMessage());
        }
        return lista;
    }
}

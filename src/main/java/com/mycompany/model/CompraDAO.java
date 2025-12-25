package com.mycompany.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import java.text.SimpleDateFormat;


public class CompraDAO {

    private static final SimpleDateFormat FORMATO_FECHA =
            new SimpleDateFormat("yyyy-MM-dd");

    // GUARDAR
    public void guardar(Compra c) {
        String sql = """
            INSERT INTO compra 
            (id_proveedor, fecha_compra, precio_compra, observaciones)
            VALUES (?, ?, ?, ?)
        """;

        try (
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
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
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ) {
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
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ) {
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
            Connection cn = Conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(sql)
        ) {
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
            Connection cn = Conexion.getConexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql)
        ) {
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
}


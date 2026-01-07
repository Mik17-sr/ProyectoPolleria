package com.mycompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaDAO implements DAO<Venta> {

    private static final String SQL_INSERT = "INSERT INTO venta(id_cliente, fecha_venta, precio_venta, observaciones) VALUES (?, ?, ?, ?)";
    private static final String SQL_READ_ALL = "SELECT v.id_venta id, c.nombre AS cliente, v.fecha_venta AS fecha, v.precio_venta AS precio, v.observaciones AS observaciones FROM venta v INNER JOIN cliente c ON v.id_cliente = c.id_cliente";
    private static final String SQL_TOTAL_PENDIENTE = """
                                                      SELECT 
                                                          IFNULL(SUM(v.precio_venta - IFNULL(p.total_pagado,0)),0) AS total_pendiente
                                                      FROM venta v
                                                      LEFT JOIN (
                                                          SELECT id_venta, SUM(monto_pago) AS total_pagado
                                                          FROM pago
                                                          GROUP BY id_venta
                                                      ) p ON p.id_venta = v.id_venta
                                                      WHERE IFNULL(p.total_pagado,0) < v.precio_venta;
                                                      """;
    private static final String SQL_CANTIDAD_PENDIENTES = """
                                                          SELECT COUNT(*) AS ventas_pendientes
                                                          FROM venta v
                                                          LEFT JOIN (
                                                              SELECT id_venta, SUM(monto_pago) AS total_pagado
                                                              FROM pago
                                                              GROUP BY id_venta
                                                          ) p ON p.id_venta = v.id_venta
                                                          WHERE IFNULL(p.total_pagado,0) < v.precio_venta;
                                                          """;

    @Override
    public boolean create(Venta object) {
        PreparedStatement ps;
        ResultSet rs = null;
        Connection cx = Conexion.getConexion();
        try {
            ps = cx.prepareStatement(SQL_INSERT);
            ps.setInt(1, object.getCliente().getIdCliente());
            java.util.Date fecha = object.getFecha();
            ps.setString(2, new java.sql.Date(fecha.getTime()).toString());
            ps.setDouble(3, object.getPrecio());
            ps.setString(4, object.getObservacion());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                // Obtenemos el ID y lo guardamos dentro del objeto 'object'
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idRecuperado = rs.getInt(1);
                    object.setId(idRecuperado); // <-- LA CLAVE: El objeto ahora "lleva" su ID
                }
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: No se inserto el dato dentro de la BD");
        } finally {
            try {
                cx.close();
            } catch (Exception er) {
                System.out.println("Error: No se pudo cerrar la conexion");
            }
        }
        return false;
    }

    public double obtenerTotalPendiente() {
        double total = 0;
        Connection cx = Conexion.getConexion();

        try (PreparedStatement ps = cx.prepareStatement(SQL_TOTAL_PENDIENTE); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("total_pendiente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener total pendiente");
            e.printStackTrace();
        }

        return total;
    }

    public int obtenerCantidadVentasPendientes() {
        int cantidad = 0;
        Connection cx = Conexion.getConexion();

        try (PreparedStatement ps = cx.prepareStatement(SQL_CANTIDAD_PENDIENTES); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                cantidad = rs.getInt("ventas_pendientes");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de ventas pendientes");
            e.printStackTrace();
        }

        return cantidad;
    }

    @Override
    public boolean delete(Venta object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Venta object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta read(Venta object) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection cx = Conexion.getConexion();
//
//        // Consulta SQL buscando por el ID de la venta
//        String sql = "SELECT id_venta, cliente_id, fecha, precio, observacion FROM ventas WHERE id_venta = ?";
//
//        try {
//            ps = cx.prepareStatement(sql);
//            ps.setInt(1, object.getIdVenta()); // Usamos el ID que ya viene en el objeto
//
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                // Llenamos el objeto con los datos encontrados
//                object.setIdVenta(rs.getInt("id_venta"));
//                object.setPrecio(rs.getDouble("precio"));
//                object.setObservacion(rs.getString("observacion"));
//                object.setFecha(rs.getDate("fecha"));
//
//                // Nota: Aquí podrías necesitar cargar el objeto Cliente también
//                // Dependiendo de si tu modelo Venta tiene un objeto Cliente o solo el ID
//                if (object.getCliente() == null) {
//                    object.setCliente(new Cliente());
//                }
//                object.getCliente().setIdCliente(rs.getInt("cliente_id"));
//
//                return object; // Retornamos el objeto lleno
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error al leer la venta: " + ex.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (cx != null) {
//                    cx.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar conexión: " + e.getMessage());
//            }
//        }
//        return null; // Si no lo encuentra o hay error, retorna null
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public List<Venta> readAll() {
        ArrayList<Venta> ventas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection cx = Conexion.getConexion();
        try {
            ps = cx.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                Cliente client = new Cliente();
                client.setNombre(rs.getString("cliente"));
                venta.setId(rs.getInt("id"));
                venta.setCliente(client);
                String fechaStr = rs.getString("fecha");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(fechaStr);
                venta.setFecha(fecha);
                venta.setPrecio(rs.getDouble("precio"));
                venta.setObservacion(rs.getString("observaciones"));
                ventas.add(venta);
            }
            return ventas;
        } catch (SQLException ex) {
            System.out.println("Error: No se obtuvieron los datos de la BD");
        } catch (ParseException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Venta read2(int idVenta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cx = Conexion.getConexion();
        Venta venta = null;

        // Ajustado a los nombres reales de tu tabla: fecha_venta, precio_venta, observaciones
        String sql = "SELECT v.*, c.nombre FROM venta v "
                + "INNER JOIN cliente c ON v.id_cliente = c.id_cliente "
                + "WHERE v.id_venta = ?";

        try {
            ps = cx.prepareStatement(sql);
            ps.setInt(1, idVenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                venta = new Venta();

                // Atributos de la clase Transaccion (Superclase)
                venta.setId(rs.getInt("id_venta"));
                venta.setPrecio(rs.getDouble("precio_venta")); // Según tu imagen
                venta.setFecha(rs.getDate("fecha_venta"));    // Según tu imagen

                // Atributos de la clase Venta
                venta.setObservacion(rs.getString("observaciones")); // Según tu imagen (plural)

                // Objeto Cliente relacionado
                Cliente cl = new Cliente();
                cl.setIdCliente(rs.getInt("id_cliente"));
                cl.setNombre(rs.getString("nombre")); // Asumiendo que la tabla cliente tiene 'nombre'
                venta.setCliente(cl);

                // Inicializamos la lista de pagos para evitar errores de puntero nulo
                venta.setPagos(new ArrayList<Pago>());
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer venta por ID: " + ex.getMessage());
        } finally {
            // Método de utilidad para cerrar recursos (o puedes hacerlo manual como antes)
            cerrarRecursos(rs, ps, cx);
        }
        return venta;
    }

// Método auxiliar para mantener el código limpio
    private void cerrarRecursos(ResultSet rs, PreparedStatement ps, Connection cx) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cx != null) {
                cx.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }

    public int obtenerTotalRegistros() {
        String sql = "SELECT COUNT(*) AS total FROM venta";
        int total = 0;

        try (Connection cx = Conexion.getConexion(); PreparedStatement ps = cx.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar los registros de ventas: " + e.getMessage());
            e.printStackTrace();
        }

        return total;
    }

}

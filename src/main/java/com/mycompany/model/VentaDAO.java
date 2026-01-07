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

public class VentaDAO implements DAO<Venta>{
    private static final String SQL_INSERT = "INSERT INTO venta(id_cliente, fecha_venta, precio_venta, observaciones) VALUES (?, ?, ?, ?)";
    private static final String SQL_READ_ALL = "SELECT v.id_venta id, c.nombre AS cliente, v.fecha_venta AS fecha, v.precio_venta AS precio, v.observaciones AS observaciones FROM venta v INNER JOIN cliente c ON v.id_cliente = c.id_cliente";
    private static final String SQL_READ_DINERO = """
                                                    SELECT 
                                                        SUM(v.precio_venta - IFNULL(p.total_pagado, 0)) AS total_pendiente
                                                    FROM venta v
                                                    LEFT JOIN (
                                                        SELECT id_venta, SUM(monto_pago) AS total_pagado
                                                        FROM pago
                                                        GROUP BY id_venta
                                                    ) p ON p.id_venta = v.id_venta
                                                    WHERE IFNULL(p.total_pagado, 0) < v.precio_venta;
                                                    """;
    private static final String SQL_READ_PENDIENTES = """
                                                      SELECT COUNT(*) AS ventas_pendientes
                                                      FROM venta v
                                                      LEFT JOIN (
                                                          SELECT id_venta, SUM(monto_pago) AS total_pagado
                                                          FROM pago
                                                          GROUP BY id_venta
                                                      ) p ON p.id_venta = v.id_venta
                                                      WHERE IFNULL(p.total_pagado, 0) < v.precio_venta;
                                                      """;
    @Override
    public boolean create(Venta object) {
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_INSERT);
            ps.setInt(1, object.getCliente().getIdCliente());
            java.util.Date fecha = object.getFecha();
            ps.setString(2, new java.sql.Date(fecha.getTime()).toString());
            ps.setDouble(3, object.getPrecio());
            ps.setString(4, object.getObservacion());
            int filas = ps.executeUpdate();
            return filas > 0;
        }catch(SQLException ex){
            System.out.println("Error: No se inserto el dato dentro de la BD");
        }finally {
            try{
                cx.close();
            }catch(Exception er){
                System.out.println("Error: No se pudo cerrar la conexion");
            }
        }
        return false;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venta> readAll() {
        ArrayList<Venta> ventas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next()){
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
        }catch(SQLException ex){
            System.out.println("Error: No se obtuvieron los datos de la BD");
        } catch (ParseException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public double obtenerTotalPendiente() {
        double total = 0;
        Connection cx = Conexion.getConexion();
        try (PreparedStatement ps = cx.prepareStatement(SQL_READ_DINERO);
            ResultSet rs = ps.executeQuery()) {
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
        try (PreparedStatement ps = cx.prepareStatement(SQL_READ_PENDIENTES);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                cantidad = rs.getInt("ventas_pendientes");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de ventas pendientes");
            e.printStackTrace();
        }
        return cantidad;
    }
}

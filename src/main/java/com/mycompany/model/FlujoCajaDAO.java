package com.mycompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlujoCajaDAO {
    private static final String SQL_FLUJO_CAJA = """
                                                 SELECT 
                                                     date(fecha) AS dia,
                                                     SUM(cobros) AS total_cobros,
                                                     SUM(pagos) AS total_pagos
                                                 FROM (
                                                     SELECT fecha_pago AS fecha, monto_pago AS cobros, 0 AS pagos
                                                     FROM pago
                                                 
                                                     UNION ALL
                                                 
                                                     SELECT fecha_pago AS fecha, 0 AS cobros, monto_pago AS pagos
                                                     FROM pago_proveedor
                                                 )
                                                 WHERE date(fecha) BETWEEN ? AND ?
                                                 GROUP BY date(fecha)
                                                 ORDER BY date(fecha);
                                                 """;
    
    public List<FlujoCaja> obtenerFlujoDiario() {
        List<FlujoCaja> lista = new ArrayList<>();
        String sql = """
            SELECT 
                f.fecha,
                IFNULL(p.cobros, 0) AS cobros,
                IFNULL(c.pagos, 0) AS pagos
            FROM (
                SELECT date(fecha_pago) AS fecha FROM pago
                UNION
                SELECT date(fecha_compra) FROM compra
            ) f
            LEFT JOIN (
                SELECT date(fecha_pago) AS fecha, SUM(monto_pago) AS cobros
                FROM pago
                GROUP BY date(fecha_pago)
            ) p ON p.fecha = f.fecha
            LEFT JOIN (
                SELECT date(fecha_compra) AS fecha, SUM(precio_compra) AS pagos
                FROM compra
                GROUP BY date(fecha_compra)
            ) c ON c.fecha = f.fecha
            ORDER BY f.fecha;
        """;
        try (Connection cx = Conexion.getConexion();
             PreparedStatement ps = cx.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new FlujoCaja(
                    rs.getString("fecha"),
                    rs.getDouble("cobros"),
                    rs.getDouble("pagos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener flujo diario");
            e.printStackTrace();
        }

        return lista;
    }

    
    public List<FlujoCaja> obtenerFlujoSemanal(int anio, int semana) {
        List<FlujoCaja> lista = new ArrayList<>();
        String sql = """
            SELECT 
                strftime('%Y-W%W', fecha) AS semana,
                SUM(cobros) AS cobros,
                SUM(pagos) AS pagos
            FROM (
                SELECT fecha, monto AS cobros, 0 AS pagos FROM pago
                UNION ALL
                SELECT fecha, 0, precio FROM compra
            )
            WHERE strftime('%Y', fecha) = ?
              AND strftime('%W', fecha) = ?
            GROUP BY semana
        """;

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(anio));
            ps.setString(2, String.format("%02d", semana));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new FlujoCaja(
                    rs.getString("semana"),
                    rs.getDouble("cobros"),
                    rs.getDouble("pagos")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    public List<FlujoCaja> obtenerFlujoMensual(int anio, int mes) {
        List<FlujoCaja> lista = new ArrayList<>();
        String sql = """
            SELECT date(fecha) AS dia,
                   SUM(cobros) AS cobros,
                   SUM(pagos) AS pagos
            FROM (
                SELECT fecha, monto AS cobros, 0 AS pagos FROM pago
                UNION ALL
                SELECT fecha, 0, precio FROM compra
            )
            WHERE strftime('%Y', fecha) = ?
              AND strftime('%m', fecha) = ?
            GROUP BY dia
            ORDER BY dia
        """;

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(anio));
            ps.setString(2, String.format("%02d", mes));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new FlujoCaja(
                    rs.getString("dia"),
                    rs.getDouble("cobros"),
                    rs.getDouble("pagos")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    public List<FlujoCaja> obtenerFlujoPorRango(LocalDate inicio, LocalDate fin) {
        List<FlujoCaja> lista = new ArrayList<>();
        String sql = """
            SELECT 
                f.fecha,
                IFNULL(p.cobros, 0) AS cobros,
                IFNULL(c.pagos, 0) AS pagos
            FROM (
                SELECT date(fecha_pago) AS fecha FROM pago
                UNION
                SELECT date(fecha_compra) FROM compra
            ) f
            LEFT JOIN (
                SELECT date(fecha_pago) AS fecha, SUM(monto_pago) AS cobros
                FROM pago
                GROUP BY date(fecha_pago)
            ) p ON p.fecha = f.fecha
            LEFT JOIN (
                SELECT date(fecha_compra) AS fecha, SUM(precio_compra) AS pagos
                FROM compra
                GROUP BY date(fecha_compra)
            ) c ON c.fecha = f.fecha
            WHERE f.fecha BETWEEN ? AND ?
            ORDER BY f.fecha;
        """;

        try (Connection cx = Conexion.getConexion();
             PreparedStatement ps = cx.prepareStatement(sql)) {

            ps.setString(1, inicio.toString());
            ps.setString(2, fin.toString());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FlujoCaja f = new FlujoCaja();
                f.setFecha(rs.getString("fecha"));
                f.setCobros(rs.getDouble("cobros"));
                f.setPagos(rs.getDouble("pagos"));
                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener flujo por rango");
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<FlujoCaja> obtenerFlujoAnual(int anio) {
        List<FlujoCaja> lista = new ArrayList<>();
        String sql = """
            SELECT strftime('%m', fecha) AS mes,
                   SUM(cobros) AS cobros,
                   SUM(pagos) AS pagos
            FROM (
                SELECT fecha, monto AS cobros, 0 AS pagos FROM pago
                UNION ALL
                SELECT fecha, 0, precio FROM compra
            )
            WHERE strftime('%Y', fecha) = ?
            GROUP BY mes
            ORDER BY mes
        """;

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(anio));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new FlujoCaja(
                    "Mes " + rs.getString("mes"),
                    rs.getDouble("cobros"),
                    rs.getDouble("pagos")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}

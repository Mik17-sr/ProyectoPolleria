package com.mycompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO implements DAO<Pago> {
    public static final String SQL_INSERT = "INSERT INTO pago(id_venta, fecha_pago, monto_pago, metodo_pago, observaciones) VALUES (?, ?, ?, ?, ?)";
    public static final String SQL_READ_BY_VENTA = "SELECT p.id_pago, p.monto_pago FROM pago p WHERE p.id_venta = ?";
    
    
    @Override
    public boolean create(Pago object) {
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_INSERT);
            ps.setInt(1, object.getVenta().getId());
            java.util.Date fecha = object.getFechaPago();
            ps.setString(2, new java.sql.Date(fecha.getTime()).toString());
            ps.setDouble(3, object.getMonto());
            ps.setString(4, object.getMetodoPago());
            ps.setString(5, object.getObservaciones());
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
    public boolean delete(Pago object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Pago object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pago read(Pago object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> readAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public List<Pago> readAllByVenta(int idVenta) {
        List<Pago> pagos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cx = Conexion.getConexion();

        try {
            ps = cx.prepareStatement(SQL_READ_BY_VENTA);
            ps.setInt(1, idVenta); 
            rs = ps.executeQuery();
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("id_pago"));
                pago.setMonto(rs.getDouble("monto_pago"));
                Venta venta = new Venta();
                venta.setId(idVenta);
                pago.setVenta(venta);
                pagos.add(pago);
            }
        }catch (SQLException ex) {
            System.out.println("Error al listar pagos por venta");
            ex.printStackTrace();
        }finally {
            try{
                cx.close();
            }catch(Exception er){
                System.out.println("Error: No se pudo cerrar la conexion");
            }
        }
        return pagos;
    }
}

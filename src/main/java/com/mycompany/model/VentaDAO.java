package com.mycompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VentaDAO implements DAO<Venta>{
    private static final String SQL_INSERT = "INSERT INTO venta(id_cliente, fecha_venta, precio_venta, observaciones) VALUES (?, ?, ?, ?)";

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

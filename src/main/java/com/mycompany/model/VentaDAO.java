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
    
}

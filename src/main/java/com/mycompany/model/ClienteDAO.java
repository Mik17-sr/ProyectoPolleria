package com.mycompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente>{
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, telefono, direccion) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
    private static final String SQL_READ_ALL = "SELECT * FROM cliente";
    private static final String SQL_READ_DEUDORES = """
                                                    SELECT 
                                                        c.id_cliente,
                                                        c.nombre,
                                                        SUM(v.precio_venta - IFNULL(p.total_pagado, 0)) AS total_adeudado
                                                    FROM cliente c
                                                    JOIN venta v ON v.id_cliente = c.id_cliente
                                                    LEFT JOIN (
                                                        SELECT id_venta, SUM(monto_pago) AS total_pagado
                                                        FROM pago
                                                        GROUP BY id_venta
                                                    ) p ON p.id_venta = v.id_venta
                                                    WHERE IFNULL(p.total_pagado, 0) < v.precio_venta
                                                    GROUP BY c.id_cliente, c.nombre;
                                                    """;
    
    @Override
    public boolean create(Cliente object) {
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_INSERT);
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getTelefono());
            ps.setString(3, object.getDireccion());
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
    public boolean delete(Cliente object) {
        // Metodo no usado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Cliente object) {
        PreparedStatement ps;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getTelefono());
            ps.setString(3, object.getDireccion());
            ps.setInt(4, object.getIdCliente());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        }catch(SQLException ex){    
            System.out.println("Error: No se actializo el dato dentro de la BD");
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
    public Cliente read(Cliente object) {
        // Metodo no usado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> readAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente(rs.getInt("id_cliente")
                        , rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"));
                clientes.add(c);
            }
            return clientes;
        }catch(SQLException ex){
            System.out.println("Error: No se obtuvieron los datos de la BD");
        }
        return null;
    }
    
    public List<Object[]> readClientesConDeuda() {
        List<Object[]> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(SQL_READ_DEUDORES);
            rs = ps.executeQuery();
            while (rs.next()){
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_cliente");       
                fila[1] = rs.getString("nombre");        
                fila[2] = rs.getDouble("total_adeudado");
                clientes.add(fila);
            }
        }catch (SQLException ex){
            System.out.println("Error al listar clientes con deuda");
            ex.printStackTrace();
        }finally{
            try{
                cx.close();
            }catch(Exception er){
                System.out.println("Error: No se pudo cerrar la conexion");
            }
        }
        return clientes;
    }
}

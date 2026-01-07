package com.mycompany.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        //String ruta = new File("resources/pollodb.db").getAbsolutePath();
        String ruta = "pollodb.db";
        String url = "jdbc:sqlite:" + ruta;
        try{
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(url);
            if(conexion != null){
                System.out.println("Conexion SQLite Exitosa");
            }
        }catch(ClassNotFoundException e){
            System.out.println("Error: Driver SQLite no encontrado");
            return null;
        } catch (SQLException e) { 
            System.out.println("Error al conectarse a SQLite: " + e.getMessage());
            return null;
        }
        return conexion;
    }  
}

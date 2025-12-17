package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConexion {

    private static final String BD = "pollodb.db";
    private static final String CADENA =
            "jdbc:sqlite:" + System.getProperty("user.dir") + "/" + BD;

    public Connection establecerconexion() throws SQLException {
        return DriverManager.getConnection(CADENA);
    }
}

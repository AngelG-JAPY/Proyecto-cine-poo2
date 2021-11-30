/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Red;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author USUARIO
 */
public class BaseDeDatos {
    //Direccion, puerto, nombre de la base de datos. Adicional, usuario y clave
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinemania?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "root";
    public static final String DB_CLAVE = "Yamaha423"; //poner su clave de acceso al phpmyadmin

    public BaseDeDatos() {

    }

    public static DataSource getDataSource() {
        //Se crea un BasicData
        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(DB_USER);
        bs.setPassword(DB_CLAVE);
        //Se especifica la cantidad de conexiones a realizar
        bs.setInitialSize(5);
        return bs;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }

    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }
    
    public static void closeStatement(Statement st) throws SQLException {
        st.close();
    }
    
    public static void closeResult(ResultSet rset) throws SQLException{
        rset.close();
    }
    
    public static void closePreparedStatement(PreparedStatement pstmt) throws SQLException{
        pstmt.close();
    }
}

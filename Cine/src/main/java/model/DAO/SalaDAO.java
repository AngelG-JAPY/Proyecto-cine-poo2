/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Sala;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class SalaDAO {
    public static final String SQL_CONSULTA = "SELECT * FROM sala";
    public static final String SQL_INSERT = "INSERT INTO sala (documento, nombre, apellido) VALUES (?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM sala WHERE documento = ?";
    public static final String SQL_UPDATE = "UPDATE sala SET nombre = ?, apellido = ?, WHERE documento = ?";
    
    
    public int Insertar(Sala sala){
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, sala.getId());
            ps.setInt(2, sala.getAsientos() );
           
            registros = ps.executeUpdate();
            if(registros== 1){
                System.out.println("Sala Insertada");
            }
            else{
                System.out.println("Error");
            }
        } 
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Cerrada la conexión");
                }
                if (ps != null) {
                    ps.close();
                    System.out.println("Cerrada la consultaa");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int borrar(Sala sala) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setString(1, sala.getId());
            registros = ps.executeUpdate();
        }
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Cerrada la conexión");
                }
                if (ps != null) {
                    ps.close();
                    System.out.println("Cerrada la consultaa");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        
        return registros;    
    }

   
    public int actualizar(Sala sala) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, sala.getId());
            ps.setInt(2, sala.getAsientos());
            
            registros = ps.executeUpdate();
            
            if(registros== 1){
                System.out.println("Sala Actualizada");
            }
            else{
                System.out.println("Error");
            }
            
            
        } 
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Cerrada la conexión");
                }
                if (ps != null) {
                    ps.close();
                    System.out.println("Cerrada la consultaa");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        
        return registros;
    }

 
    public List<Sala> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Sala> salalist = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
              Sala sala = new Sala ();
               sala.setId(res.getString("id_sala"));
               sala.setAsientos(res.getInt("n_asientos"));
               salalist.add(sala);
           }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
           
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Cerrada la conexión");
                }
                if (ps != null) {
                    ps.close();
                    System.out.println("Cerrada la consultaa");
                }
                if(res != null){
                    res.close();
                    System.out.println("Cerrado los resultados");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            
        }
        }
        return salalist;
    }
}


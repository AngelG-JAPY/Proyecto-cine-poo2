/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Confiteria;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class ConfiteriaDAO {
    public static final String SQL_CONSULTA = "SELECT * FROM confiteria";
    public static final String SQL_INSERT = "INSERT INTO confiteria (id, nombre, precio, cantidad) VALUES (?, ?, ?,?)";
    public static final String SQL_DELETE = "DELETE FROM confiteria WHERE id = ?";
    public static final String SQL_UPDATE = "UPDATE confiteria SET nombre = ?, precio = ?,cantidad = ? WHERE id = ?";
    
    
    public int Insertar(Confiteria confiteria){
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, confiteria.getId());
            ps.setString(2, confiteria.getNombre());
            ps.setInt(3, confiteria.getCantidad());
            ps.setInt(4, confiteria.getPrecio());
            registros = ps.executeUpdate();
             if(registros== 1){
                System.out.println("Confiteria Agregada");
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
    
    public int borrar(Confiteria confiteria) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, confiteria.getId());
            registros = ps.executeUpdate();
             if(registros== 1){
                System.out.println("Confiteria Borrada");
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

   
    public int actualizar(Confiteria confiteria) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, confiteria.getNombre());
            ps.setInt(2, confiteria.getPrecio());
            ps.setInt(3, confiteria.getCantidad());
            ps.setInt(4, confiteria.getId());
            registros = ps.executeUpdate();
             if(registros== 1){
                System.out.println("Confiteria Actualizada");
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

 
    public List<Confiteria> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Confiteria> comidalist = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
              Confiteria confiteria = new Confiteria ();
               confiteria.setId(res.getInt("id"));
               confiteria.setNombre(res.getString("nombre"));
               confiteria.setPrecio(res.getInt("precio"));
               confiteria.setCantidad(res.getInt("cantidad"));
               comidalist.add(confiteria);
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
        return comidalist;
    }
    
}


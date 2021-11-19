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
import static model.DAO.SalaDAO.SQL_CONSULTA;
import static model.DAO.SalaDAO.SQL_DELETE;
import static model.DAO.SalaDAO.SQL_INSERT;
import static model.DAO.SalaDAO.SQL_UPDATE;
import model.Entity.Tarifa;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class TarifaDAO {
    public static final String SQL_CONSULTA = "SELECT * FROM confiteria";
    public static final String SQL_INSERT = "INSERT INTO confiteria (documento, nombre, apellido) VALUES (?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM confiteria WHERE documento = ?";
    public static final String SQL_UPDATE = "UPDATE confiteria SET nombre = ?, apellido = ?, WHERE documento = ?";

    public int Insertar(Tarifa tarifa){
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, tarifa.getIdTarifa());
            ps.setString(2, tarifa.getNombre());
            ps.setInt(3, tarifa.getPrecio());
            ps.setString(4, tarifa.getRebaja());
           
            registros = ps.executeUpdate();
            if(registros== 1){
                System.out.println("Tarifa Insertada");
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
    
    public int borrar(Tarifa tarifa) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, tarifa.getIdTarifa());
            registros = ps.executeUpdate();
            if(registros== 1){
                System.out.println("Tarifa Borrada");
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

   
    public int actualizar(Tarifa tarifa) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setInt(1, tarifa.getIdTarifa());
            ps.setString(1, tarifa.getNombre());
            ps.setInt(1, tarifa.getPrecio());
            ps.setString(1, tarifa.getRebaja());
            
            registros = ps.executeUpdate();
            
            if(registros== 1){
                System.out.println("Tarifa Actualizada");
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

 
    public List<Tarifa> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Tarifa> tarifalist = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
              Tarifa tarifa = new Tarifa ();
               tarifa.setIdTarifa(res.getInt("id_Tarifa"));
               tarifa.setNombre(res.getString("nombre"));
               tarifa.setPrecio(res.getInt("precio"));
               tarifalist.add(tarifa);
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
        return tarifalist;
    }
}

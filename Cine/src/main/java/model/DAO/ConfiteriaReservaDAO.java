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
import model.Entity.Confiteria;
import model.Entity.ConfiteriaReserva;
import model.Entity.Sala;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class ConfiteriaReservaDAO {
    public static final String SQL_CONSULTA = "SELECT * FROM confiteriareserva";
    public static final String SQL_INSERT = "INSERT INTO confiteriareserva (documento, nombre, apellido) VALUES (?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM confiteriareserva WHERE documento = ?";
    public static final String SQL_UPDATE = "UPDATE confiteriareserva SET nombre = ?, apellido = ?, WHERE documento = ?";
    
    
    public int Insertar(ConfiteriaReserva confiteriareserva){
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, confiteriareserva.getIdComidaReserva());
            ps.setInt(2, confiteriareserva.getComida().getId());
            
            registros = ps.executeUpdate();
            if(registros== 1){
                System.out.println("Reserva de Comida Insertada");
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
    
    public int borrar(ConfiteriaReserva confiteriareserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, confiteriareserva.getIdComidaReserva());
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

   
    public int actualizar(ConfiteriaReserva confiteriareserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setInt(1, confiteriareserva.getIdComidaReserva());
            ps.setInt(2, confiteriareserva.getComida().getId());
            
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

 
    public List<ConfiteriaReserva> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<ConfiteriaReserva> confiteriareservalist = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
               Confiteria c = new Confiteria();
                ConfiteriaReserva confiteriareserva = new ConfiteriaReserva();
                confiteriareserva.setIdComidaReserva(res.getInt("id_confiteriareserva"));
                
               
               confiteriareservalist.add(confiteriareserva);
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
        return confiteriareservalist;
    }
}

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
import model.Entity.Programacion;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class ProgramacionDAO {

    private static final String QUERY_INSERTAR
            = "INSERT INTO programacion (id_programacion, fecha_incio, fecha_fin) VALUES (?,?,?)";

    private static final String QUERY_LISTAR = "SELECT * FROM programacion";

    private static final String QUERY_ACTULIZAR = "UPDATE programacion SET fecha_inicio = ?, fecha_fin = ? WHERE id_programacion = ?";

    private static final String QUERY_ELIMINAR = "DELETE FROM programacion WHERE id_programacion = ?";
    
    public void insertarProgramacion(Programacion p){
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_INSERTAR);

            ps.setInt(1, p.getIdProgramacion());
            ps.setString(2, p.getFechaInicio());
            ps.setString(3, p.getFechaFin());
            
            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Registrada la programación");
            } else {
                System.out.println("Ocurrio un error");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
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
    }
    
    public List<Programacion> listarProgramacion(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        List<Programacion> listaProgramacion = new ArrayList();
        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_LISTAR);

            rset = ps.executeQuery();
            
            while(rset.next()){
                Programacion p = new Programacion();
                p.setIdProgramacion(rset.getInt("id_programacion"));
                p.setFechaInicio(rset.getString("fecha_inicio"));
                p.setFechaFin(rset.getString("fecha_fin"));
                listaProgramacion.add(p); 
            }

           

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Cerrada la conexión");
                }
                if (ps != null) {
                    ps.close();
                    System.out.println("Cerrada la consultaa");
                }
                if(rset != null){
                    rset.close();
                    System.out.println("Cerrado los resultados");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return listaProgramacion;
    }
    
    public void actualizarProgramacion(Programacion p){
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ACTULIZAR);

            ps.setString(1, p.getFechaInicio());
            ps.setString(2, p.getFechaFin());
            ps.setInt(3, p.getIdProgramacion());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Actualizada la programación");
            } else {
                System.out.println("Ocurrio un error");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
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
    }
    
    public void eliminarProgramacion(Programacion p){
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ELIMINAR);

            ps.setInt(1, p.getIdProgramacion());
            

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Programación eliminada");
            } else {
                System.out.println("Ocurrio un error");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
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
    }
}

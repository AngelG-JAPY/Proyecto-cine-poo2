
package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Membresia;
import model.Entity.Reserva;
import model.Entity.Usuario;
import model.Red.BaseDeDatos;


public class ReservaDAO {
    public static final String SQL_CONSULTA = "SELECT r.id_reserva, r.id_funcion, r.id_comida, u.documento, u.nombre, u.genero, u.email, u.contraseña, u.telefono, m.id, m.nombre as nombre_membresia, m.valor, r.fecha_funcion, r.fecha_reserva, r.precio_reserva, r.cantidad_sillas FROM reserva u\n" +
                                              "JOIN usuario u ON (r.id_usuario = u.documento), JOIN membresia m ON (u.id_membresia = m.id)";
    public static final String SQL_INSERT = "INSERT INTO reserva (id_reserva, id_funcion, id_comida, id_usuario, fecha_funcion, fecha_reserva, precio_reserva, cantidad_sillas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM reserva WHERE id_reserva = ?";
    public static final String SQL_UPDATE = "UPDATE reserva SET id_funcion = ?, id_comida = ?, id_usuario = ?, fecha_funcion = ?, fecha_reserva = ?, precio_reserva = ?, cantidad_sillas = ?, WHERE id_reserva = ?";
    
    public int insertar(Reserva reserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            Usuario u = new Usuario();
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, reserva.getId_reserva());
            ps.setInt(2, reserva.getId_funcion());
            ps.setInt(3, reserva.getId_comida());
            ps.setInt(4, reserva.getId_usuario().getId_usuario());
            ps.setDate(5, (Date) reserva.getFecha_funcion());
            ps.setDate(6, (Date) reserva.getFecha_reserva());
            ps.setInt(7, reserva.getPrecio_reserva());
            ps.setInt(8, reserva.getCantidad_sillas());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try{
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            }
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int borrar(Reserva reserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, reserva.getId_reserva());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try{
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            }
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registros;    
    }

    public int actualizar(Reserva reserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setInt(1, reserva.getId_reserva());
            ps.setInt(2, reserva.getId_funcion());
            ps.setInt(3, reserva.getId_comida());
            ps.setInt(4, reserva.getId_usuario().getId_usuario());
            ps.setDate(5, (Date) reserva.getFecha_funcion());
            ps.setDate(6, (Date) reserva.getFecha_reserva());
            ps.setInt(7, reserva.getPrecio_reserva());
            ps.setInt(8, reserva.getCantidad_sillas());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try{
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            }
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public List<Reserva> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Reserva> reservas = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
               Reserva r = new Reserva ();
               Usuario u = new Usuario();
               Membresia m = new Membresia ();
               r.setId_reserva(res.getInt("id_reserva"));
               r.setId_funcion(res.getInt("id_funcion"));
               r.setId_comida(res.getInt("id_comida"));   
               u.setId_usuario(res.getInt("documento"));
               u.setNombre(res.getString("nombre"));
               u.setGenero(res.getString("genero"));
               u.setEmail(res.getString("correo"));
               u.setContraseña(res.getString("contraseña"));
               u.setTelefono(res.getInt("telefono"));
               m.setId_membresia(res.getInt("id"));
               m.setNombre(res.getString("nombre_membresia"));
               m.setValor(res.getInt("valor"));
               u.setMembresia(m);
               r.setId_usuario(u);
               r.setFecha_funcion(res.getDate("fecha_funcion"));
               r.setFecha_reserva(res.getDate("fecha_reserva"));
               r.setPrecio_reserva(res.getInt("precio_reserva"));
               r.setCantidad_sillas(res.getInt("cantidad_sillas"));
           }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try{
                BaseDeDatos.closeResult(res);
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            }
            catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return reservas;
    }
}

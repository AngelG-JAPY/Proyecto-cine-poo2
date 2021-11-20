
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
    public static final String SQL_CONSULTA = "SELECT id_reserva, id_funcion, id_comida, id_usuario, fecha_funcion, fecha_reserva, precio_reserva, cantidad_sillas FROM reserva u\n" +
                                              "JOIN membresia m ON (u.id_membresia = m.id)";
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
               Membresia m = new Membresia ();
               s.setId_usuario(res.getInt("documento"));
               s.setNombre(res.getString("nombre"));
               s.setGenero(res.getString("genero"));
               s.setEmail(res.getString("correo"));
               s.setContraseña(res.getString("contraseña"));
               s.setTelefono(res.getInt("telefono"));
               m.setId_membresia(res.getInt("id"));
               m.setNombre(res.getString("nombre_membresia"));
               m.setValor(res.getInt("valor"));
               s.setMembresia(m);
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

package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Confiteria;
import model.Entity.Funcion;
import model.Entity.Membresia;
import model.Entity.Pelicula;
import model.Entity.Programacion;
import model.Entity.Reserva;
import model.Entity.Tarifa;
import model.Entity.Usuario;
import model.Red.BaseDeDatos;

public class ReservaDAO {

    public static final String SQL_CONSULTA = "SELECT * FROM reserva\n";
    public static final String SQL_INSERT = "INSERT INTO reserva (id_funcion, id_usuario, id_comida, fecha_funcion, fecha_reserva, precio_reserva, cantidad_asientos) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM reserva WHERE id_funcion = ?, id_usuario = ?";
    //public static final String SQL_UPDATE = "UPDATE reserva SET fecha_funcion = ?, fecha_reserva = ?, precio_reserva = ?, cantidad_asientos = ?, WHERE id = ?";

    public int insertar(Reserva reserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            Usuario u = new Usuario();
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setInt(1, reserva.getId_funcion().getId());
            ps.setInt(2, reserva.getId_usuario().getId_usuario());
            ps.setInt(3, reserva.getId_comida().getId());
            ps.setDate(4, (Date) reserva.getFecha_funcion());
            ps.setDate(5, (Date) reserva.getFecha_reserva());
            ps.setInt(6, reserva.getPrecio_reserva());
            ps.setInt(7, reserva.getCantidad_sillas());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            } catch (SQLException ex) {
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
            ps.setInt(1, reserva.getId_funcion().getId());
            s.setInt(2, reserva.getId_usuario().getId_usuario());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    /*
    public int actualizar(Reserva reserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setInt(1, reserva.getId_reserva());
            ps.setInt(2, reserva.getId_funcion().getId());
            ps.setInt(4, reserva.getId_usuario().getId_usuario());
            ps.setInt(3, reserva.getId_comida().getId());
            ps.setDate(5, (Date) reserva.getFecha_funcion());
            ps.setDate(6, (Date) reserva.getFecha_reserva());
            ps.setInt(7, reserva.getPrecio_reserva());
            ps.setInt(8, reserva.getCantidad_sillas());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }*/

    public List<Reserva> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Reserva> reservas = new ArrayList();
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_CONSULTA);
            res = ps.executeQuery();
            while (res.next()) {
                
                Reserva r = new Reserva();
                r.setId_funcion(new Funcion(res.getInt("id_funcion")));
                r.setId_usuario(new Usuario(res.getInt("id_usuario")));
                r.setId_comida(new Confiteria(res.getInt("id_comida")));
                r.setFecha_funcion(res.getDate("fecha_funcion"));
                r.setFecha_reserva(res.getDate("fecha_reserva"));
                r.setPrecio_reserva(res.getInt("precio_reserva"));
                r.setCantidad_sillas(res.getInt("cantidad_asientos"));
                reservas.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.closeResult(res);
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return reservas;
    }
}

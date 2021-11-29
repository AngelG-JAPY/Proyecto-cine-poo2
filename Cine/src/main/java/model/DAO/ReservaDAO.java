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

    public static final String SQL_CONSULTA = "SELECT * FROM reserva u\n"
            + "JOIN usuario u ON (r.id_usuario = u.documento) u\n"
            + "JOIN membresia m ON (u.id_membresia = m.id) u\n"
            + "JOIN confiteria c ON (r.id_comida = c.id) u\n"
            + "JOIN funcion f ON (r.id_funcion = f.id)";
    public static final String SQL_INSERT = "INSERT INTO reserva (id, id_funcion, id_usuario, id_comida, fecha_funcion, fecha_reserva, precio_reserva, cantidad_asientos) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM reserva WHERE id = ?";
    public static final String SQL_UPDATE = "UPDATE reserva SET id_funcion = ?, id_usuario = ?, id_comida = ?, fecha_funcion = ?, fecha_reserva = ?, precio_reserva = ?, cantidad_asientos = ?, WHERE id = ?";

    public int insertar(Reserva reserva) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            Usuario u = new Usuario();
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
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
            while (res.next()) {
                Reserva r = new Reserva();
                Usuario u = new Usuario();
                Membresia m = new Membresia();
                Confiteria c = new Confiteria();
                Funcion f = new Funcion();
                Pelicula p = new Pelicula();
                Programacion pp = new Programacion();
                Tarifa t = new Tarifa();
                
                m.setId(res.getInt("id"));
                m.setNombre(res.getString("nombre"));
                m.setValor(res.getInt("valor"));
                
                c.setId(res.getInt("id"));
                c.setNombre(res.getString("nombre"));
                c.setPrecio(res.getInt("precio"));
                c.setCantidad(res.getInt("cantidad"));
                
                u.setId_usuario(res.getInt("documento"));
                u.setNombre(res.getString("nombre"));
                u.setGenero(res.getString("genero"));
                u.setEmail(res.getString("email"));
                u.setContrasenia(res.getString("contraseña"));
                u.setTelefono(res.getInt("telefono"));
                
                u.setMembresia(m);
                
                f.setId(res.getInt("id_funcion"));

                p.setId(res.getInt("id_pelicula"));
                p.setNombre(res.getString("nombre_pelicula"));
                p.setGenero(res.getString("genero"));
                p.setDuracion(res.getInt("duracion"));
                p.setDirector(res.getString("director"));
                p.setClasificacion(res.getString("clasificacion"));
                p.setCartelera(res.getString("cartelera"));
                p.setTrailer(res.getString("trailer"));

                f.setPelicula(p);

                f.setIdSala(res.getInt("id_sala"));
                f.setHoraInicio(res.getString("hora_inicio"));
                f.setDiaSemana(res.getInt("dia_semana"));

                pp.setIdProgramacion(res.getInt("id_programacion"));
                pp.setFechaInicio(res.getDate("fecha_inicio"));
                pp.setFechaFin(res.getDate("fecha_fin"));

                t.setIdTarifa(res.getInt("id_tarifa"));
                t.setPrecio(res.getInt("precio"));
                t.setNombre(res.getString("dia"));

                f.setProgramacion(pp);
                f.setTarifa(t);
                
                r.setId_reserva(res.getInt("id"));
                r.setId_funcion(f);
                r.setId_comida(c);
                r.setId_usuario(u);
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

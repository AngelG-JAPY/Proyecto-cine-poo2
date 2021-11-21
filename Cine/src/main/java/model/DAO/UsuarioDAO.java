
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Membresia;
import model.Entity.Usuario;
import model.Red.BaseDeDatos;


public class UsuarioDAO {
    public static final String SQL_CONSULTA = "SELECT u.documento, u.nombre, u.genero, u.email, u.contraseña, u.telefono, m.id, m.nombre as nombre_membresia, m.valor FROM usuario u\n" +
                                              "JOIN membresia m ON (u.id_membresia = m.id)";
    public static final String SQL_INSERT = "INSERT INTO usuario (nombre, id_usuario, genero, email, telefono, membresia, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    public static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, genero = ?, email = ?, telefono = ?, membresia = ?, contraseña = ?, WHERE id_usuario = ?";
    public static final String SQL_CONSULTAID = "SELECT u.nombre, u.genero, u.email, u.contraseña, u.telefono, m.id, m.nombre as nombre_membresia, m.valor FROM usuario u\n" +
                                              "JOIN membresia m ON (u.id_membresia = m.id) FROM usuario WHERE id_usuario = ?";
    
    public int insertar(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            Membresia m = new Membresia();
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getId_usuario());
            ps.setString(3, usuario.getGenero());
            ps.setString(4, usuario.getEmail());
            ps.setInt(5, usuario.getTelefono());
            ps.setInt(6, usuario.getMembresia().getId_membresia());
            ps.setString(7, usuario.getContraseña());
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

    public int borrar(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, usuario.getId_usuario());
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

    public int actualizar(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getId_usuario());
            ps.setString(3, usuario.getGenero());
            ps.setString(4, usuario.getEmail());
            ps.setInt(5, usuario.getTelefono());
            ps.setInt(6, usuario.getMembresia().getId_membresia());
            ps.setString(7, usuario.getContraseña());
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

    public List<Usuario> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Usuario> usuarios = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
               Usuario s = new Usuario ();
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
        return usuarios;
    }
    
    public Usuario consultarPorID(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        Usuario u = null;
        Membresia m = null;
        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            ps.setInt(1, usuario.getId_usuario());
            res = ps.executeQuery();
            res.absolute(1);
            m = new Membresia(res.getInt("id"), res.getString("nombre_membresia"), res.getInt("valor"));
            u = new Usuario(res.getString("nombre"), res.getInt("documento"), res.getString("genero"), res.getString("correo"), res.getInt("telefono"), m, res.getString("contraseña"));

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                BaseDeDatos.closeResult(res);
                BaseDeDatos.closePreparedStatement(ps);
                BaseDeDatos.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return u;
    }
}

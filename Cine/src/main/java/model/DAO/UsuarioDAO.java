
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Usuario;
import model.Red.BaseDeDatos;


public class UsuarioDAO {
    public static final String SQL_CONSULTA = "SELECT * FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (nombre, id_usuario, genero, email, telefono, id_membresia, contraseña,) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    public static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, genero = ?, email = ?, telefono = ?, id_membresia = ?, contraseña = ?, WHERE id_usuario = ?";
    
    public int insertar(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getId_usuario());
            ps.setString(3, usuario.getGenero());
            ps.setString(4, usuario.getEmail());
            ps.setInt(5, usuario.getTelefono());
            ps.setString(6, usuario.getId_membresia());
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
            ps.setString(6, usuario.getId_membresia());
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
        List<Usuario> autores = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
               String nombre = res.getString("nombre");
               int id_usuario = res.getInt("id_usuario");
               String genero = res.getString("genero");
               String email = res.getString("email");
               int telefono = res.getInt("telefono");
               String id_membresia = res.getString("id_membresia");
               String contraseña = res.getString("contraseña");
               Usuario usuario = new Usuario(nombre, id_usuario, genero, email, telefono, id_membresia, contraseña);
               autores.add(usuario);
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
        return autores;
    }
}

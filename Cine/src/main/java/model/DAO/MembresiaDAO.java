
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Membresia;
import model.Red.BaseDeDatos;


public class MembresiaDAO {
    public static final String SQL_CONSULTA = "SELECT m.id, m.nombre, m.valor FROM membresia";
    public static final String SQL_INSERT = "INSERT INTO membresia (nombre, id, valor) VALUES (?, ?, ?)";
    public static final String SQL_DELETE = "DELETE FROM membresia WHERE id = ?";
    public static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, valor = ?, WHERE id = ?";
    
    public int insertar(Membresia membresia) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, membresia.getNombre());
            ps.setInt(2, membresia.getId_membresia());
            ps.setInt(3, membresia.getValor());
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

    public int borrar(Membresia membresia) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, membresia.getId_membresia());
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

    public int actualizar(Membresia membresia) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, membresia.getNombre());
            ps.setInt(2, membresia.getId_membresia());
            ps.setInt(3, membresia.getValor());
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

    public List<Membresia> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        List<Membresia> membresia = new ArrayList();
        try {
           con = BaseDeDatos.getConnection();
           ps = con.prepareStatement(SQL_CONSULTA);
           res = ps.executeQuery();
           while (res.next()){
               Membresia m = new Membresia ();
               m.setId_membresia(res.getInt("id"));
               m.setNombre(res.getString("nombre_membresia"));
               m.setValor(res.getInt("valor"));
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
        return membresia;
    }
}

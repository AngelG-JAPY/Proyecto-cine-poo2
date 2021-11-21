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
import model.Entity.Pelicula;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class PeliculaDAO {

    private static final String QUERY_INSERTAR
            = "INSERT INTO pelicula (nombre, genero, duracion, director, clasificacion, cartelera, trailer) VALUES (?,?,?,?,?,?,?)";

    private static final String QUERY_LISTAR = "SELECT * FROM pelicula";
    
    private static final String QUERY_ACTULIZAR = "UPDATE pelicula SET nombre = ?, genero = ?, duracion = ?, director = ?, clasificacion = ?, cartelera = ?, trailer = ? WHERE id = ?";

    private static final String QUERY_ELIMINAR = "DELETE FROM pelicula WHERE id = ?";

//C R U D
    public void insertar(Pelicula p) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_INSERTAR);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getDirector());
            ps.setString(5, p.getClasificacion());
            ps.setString(6, p.getCartelera());
            ps.setString(7, p.getTrailer());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Registrada pelicula");
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
                    System.out.println("Cerrada la consulta");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

    }

    public List<Pelicula> listarPeliculas() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        List<Pelicula> listaPeliculas = new ArrayList();
        
        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_LISTAR);
            rset = ps.executeQuery();
            
            while(rset.next()){
                Pelicula p = new Pelicula();
                p.setId(rset.getInt("id"));
                p.setNombre(rset.getString("nombre"));
                p.setGenero(rset.getString("genero"));
                p.setDuracion(rset.getInt("duracion"));
                p.setDirector(rset.getString("director"));
                p.setClasificacion(rset.getString("clasificacion"));
                p.setCartelera(rset.getString("cartelera"));
                p.setTrailer(rset.getString("trailer"));
                
                listaPeliculas.add(p);
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
        return listaPeliculas;
    }

    public void actualizarPelicula(Pelicula p) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ACTULIZAR);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getDirector());
            ps.setString(5, p.getClasificacion());
            ps.setString(6, p.getCartelera());
            ps.setString(7, p.getTrailer());
            ps.setInt(8, p.getId());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Actualizada pelicula");
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

    public void eliminarPelicula(Pelicula p) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ELIMINAR);

            ps.setInt(1, p.getId());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Eliminada la pelicula ");
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

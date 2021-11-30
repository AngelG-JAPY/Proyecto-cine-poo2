/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Entity.Funcion;
import model.Entity.Pelicula;
import model.Entity.Programacion;
import model.Entity.Tarifa;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class FuncionDAO {

    private static final String QUERY_INSERTAR
            = "INSERT INTO funcion (id, id_pelicula, id_sala, hora_inicio, dia_semana, id_programacion, id_tarifa) VALUES (?,?,?,?,?,?,?)";

    private static final String QUERY_LISTAR
            = "SELECT f.id as id_funcion,id_sala, hora_inicio, dia_semana, p.id as id_pelicula, p.nombre as nombre_pelicula, p.genero, p.duracion, p.director, p.clasificacion, p.cartelera, p.trailer, pp.id_programacion, pp.fecha_inicio, pp.fecha_fin, t.id_tarifa, t.precio, t.nombre as dia"
            + " FROM `funcion` f"
            + " JOIN pelicula p on (f.id_pelicula = p.id)"
            + " JOIN sala s on (f.id_sala = s.id)"
            + " JOIN programacion pp on (f.id_programacion = pp.id_programacion)"
            + " JOIN tarifa t on (f.id_tarifa = t.id_tarifa)";
    
    private static final String QUERY_ACTULIZAR = "UPDATE funcion SET id_pelicula = ?, id_sala = ?, hora_inicio = ?, dia_semana = ?, id_programacion = ?, id_tarifa = ? WHERE id = ?";

    private static final String QUERY_ELIMINAR = "DELETE FROM funcion WHERE id = ?";

    public void insertarFuncion(Funcion f) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_INSERTAR);

            ps.setInt(1, f.getId());
            ps.setInt(2, f.getPelicula().getId());
            ps.setInt(3, f.getIdSala());
            ps.setString(4,  f.getHoraInicio());
            ps.setInt(5, f.getDiaSemana());
            ps.setInt(6, f.getProgramacion().getIdProgramacion());
            ps.setInt(7, f.getTarifa().getIdTarifa());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Registrada la función");
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

    public List<Funcion> listarFunciones() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        List<Funcion> funciones = new ArrayList();
        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_LISTAR);

            rset = ps.executeQuery();

            while (rset.next()) {
                Funcion f = new Funcion();
                Pelicula p = new Pelicula();
                Programacion pp = new Programacion();
                Tarifa t = new Tarifa();

                f.setId(rset.getInt("id_funcion"));

                p.setId(rset.getInt("id_pelicula"));
                p.setNombre(rset.getString("nombre_pelicula"));
                p.setGenero(rset.getString("genero"));
                p.setDuracion(rset.getInt("duracion"));
                p.setDirector(rset.getString("director"));
                p.setClasificacion(rset.getString("clasificacion"));
                p.setCartelera(rset.getString("cartelera"));
                p.setTrailer(rset.getString("trailer"));

                f.setPelicula(p);

                f.setIdSala(rset.getInt("id_sala"));
                f.setHoraInicio(rset.getString("hora_inicio"));
                f.setDiaSemana(rset.getInt("dia_semana"));

                pp.setIdProgramacion(rset.getInt("id_programacion"));
                pp.setFechaInicio(rset.getDate("fecha_inicio"));
                pp.setFechaFin(rset.getDate("fecha_fin"));

                t.setIdTarifa(rset.getInt("id_tarifa"));
                t.setPrecio(rset.getInt("precio"));
                t.setNombre(rset.getString("dia"));

                f.setProgramacion(pp);
                f.setTarifa(t);

                funciones.add(f);
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
                if (rset != null) {
                    rset.close();
                    System.out.println("Cerrado los resultados");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return funciones;
    }

    public void actualizarFuncion(Funcion f) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ACTULIZAR);

            ps.setInt(1, f.getPelicula().getId());
            ps.setInt(2, f.getIdSala());
            ps.setString(3, f.getHoraInicio());
            ps.setInt(4, f.getDiaSemana());
            ps.setInt(5, f.getProgramacion().getIdProgramacion());
            ps.setInt(6, f.getTarifa().getIdTarifa());
            ps.setInt(7, f.getId());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Actualizada la función");
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

    public void eliminarFuncion(Funcion f) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ELIMINAR);

            ps.setInt(1, f.getId());

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

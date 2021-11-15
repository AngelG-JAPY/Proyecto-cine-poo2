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
import model.Entity.Tarifa;
import model.Red.BaseDeDatos;

/**
 *
 * @author USUARIO
 */
public class TarifaDAO {

    private static final String QUERY_INSERTAR
            = "INSERT INTO tarifa (precio, nombre) VALUES (?,?)";

    private static final String QUERY_LISTAR = "SELECT * FROM tarifa";

    private static final String QUERY_ACTULIZAR = "UPDATE tarifa SET precio = ?, nombre = ? WHERE id_tarifa = ?";

    private static final String QUERY_ELIMINAR = "DELETE FROM tarifa WHERE id = ?";

    public void insertar(Tarifa f) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_INSERTAR);

            ps.setInt(1, f.getPrecio());
            ps.setString(2, f.getNombre());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Registrada la tarifa");
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

    public List<Tarifa> listarTarifa() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        List<Tarifa> listaTarifas = new ArrayList();
        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_LISTAR);

            rset = ps.executeQuery();

            while (rset.next()) {
                Tarifa f = new Tarifa();
                f.setIdTarifa(rset.getInt("id_tarifa"));
                f.setPrecio(rset.getInt("precio"));
                f.setNombre(rset.getString("nombre"));
                listaTarifas.add(f);

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
        return listaTarifas;
    }

    public void actualizarTarifa(Tarifa f) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ACTULIZAR);

            ps.setInt(1, f.getPrecio());
            ps.setString(2, f.getNombre());
            ps.setInt(3, f.getIdTarifa());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Actualizada la tarifa");
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

    public void eliminarTarifa(Tarifa f) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = BaseDeDatos.getConnection();
            ps = con.prepareStatement(QUERY_ELIMINAR);

            ps.setInt(1, f.getIdTarifa());

            int consulta = ps.executeUpdate();

            if (consulta == 1) {
                System.out.println("Tarifa eliminada");
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

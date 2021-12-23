/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.MembresiaDAO;

/**
 *
 * @author USUARIO
 */
@WebServlet("/membresia")
public class MembresiaC extends HttpServlet{
    private void listarMembresias(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MembresiaDAO md = new MembresiaDAO();
        List<model.Entity.Membresia> membresias = md.consultar();
        req.setAttribute("membresias", membresias);
        req.getRequestDispatcher("membresia/vermem.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    this.eliminar(req, resp);
                    break;

                case "editar":
                    this.editar(req, resp);
                    break;

                default:
                    this.listarMembresias(req, resp);
            }
        } else {
            this.listarMembresias(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertar(req, resp);
                    break;
                case "modificar":
                    this.modificar(req, resp);
                    break;
                default:
                    this.listarMembresias(req, resp);
            }
        } else {
            this.listarMembresias(req, resp);
        }
    }

    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        int valor = Integer.valueOf(req.getParameter("valor"));
        model.Entity.Membresia m = new model.Entity.Membresia(id, nombre, valor);
        MembresiaDAO md = new MembresiaDAO();
        md.insertar(m);
        this.listarMembresias(req, resp);
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idm = req.getParameter("id");

        MembresiaDAO md = new MembresiaDAO();
        md.borrar(new model.Entity.Membresia(Integer.valueOf(idm)));
        this.listarMembresias(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idm = req.getParameter("id");
        model.Entity.Membresia membresias = new MembresiaDAO().consultarPorID(new model.Entity.Membresia(Integer.valueOf(idm)));
        req.setAttribute("membresias", membresias);
        req.getRequestDispatcher("membresia/editarmem.jsp").forward(req, resp);
    }

    private void modificar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        int valor = Integer.valueOf(req.getParameter("valor"));
        MembresiaDAO md = new MembresiaDAO();
        model.Entity.Membresia m = new model.Entity.Membresia(id, nombre, valor);
        md.actualizar(m);
        this.listarMembresias(req, resp);
    }
}

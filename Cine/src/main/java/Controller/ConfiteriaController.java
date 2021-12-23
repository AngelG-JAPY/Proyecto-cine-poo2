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
import model.DAO.ConfiteriaDAO;
import model.Entity.Confiteria;

/**
 *
 * @author USUARIO
 */
@WebServlet("/confiteria")
public class ConfiteriaController extends HttpServlet {

    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "AgregarConfiteria":
                    this.AgregarConfiteria(req, resp);
                    break;
                case "BorrarConfiteria":
                    this.BorrarConfiteria(req, resp);
                case "ActualizarConfiteria":
                    this.ActualizarConfiteria(req, resp);
                default:
                    //this.ConsultarSala(req, resp);
                    this.BorrarConfiteria(req, resp);
                //this.BorrarConfiteria(req, resp);
            }
            System.out.println("");
        } else {
            this.ConsultarConfiteria(req, resp);
        }
    }

    private void ConsultarConfiteria(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        ConfiteriaDAO cDao = new ConfiteriaDAO();
        List<Confiteria> confiterias = cDao.consultar();
        req.setAttribute("confiterias", confiterias);
        req.getRequestDispatcher("confiteria/vercomida.jsp").forward(req, resp);
    }

    private void AgregarConfiteria(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String id = req.getParameter("id");
        String precio = req.getParameter("precio");
        String cantidad = req.getParameter("cantidad");

        Confiteria confiteria = new Confiteria(nombre, id, precio, cantidad);

        int registros = new ConfiteriaDAO().Insertar(confiteria);

        this.ConsultarConfiteria(req, resp);
    }

    private void BorrarConfiteria(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int registros = new ConfiteriaDAO().borrar(new Confiteria(id));
        this.ConsultarConfiteria(req, resp);
    }

    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "AgregarConfiteria":
                    this.AgregarConfiteria(req, resp);
                    break;
                case "BorrarConfiteria":
                    this.BorrarConfiteria(req, resp);

                default:
                    //this.ConsultarSala(req, resp);
                    this.BorrarConfiteria(req, resp);
            }

        } else {
            this.ConsultarConfiteria(req, resp);
        }
    }

    private void ActualizarConfiteria(HttpServletRequest req, HttpServletResponse resp) {

    }

}

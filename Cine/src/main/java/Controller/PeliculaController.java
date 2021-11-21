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
import model.DAO.PeliculaDAO;
import model.Entity.Pelicula;

/**
 *
 * @author USUARIO
 */
@WebServlet("/peliculas")
public class PeliculaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "borrar":
                    this.borrar(req, resp);
                    break;
                    
                case "editar":
                    this.editar(req,resp);
                    break;
                    
                default:
                    this.listarPeliculas(req, resp);
            }
            this.listarPeliculas(req, resp);
        } else {
            this.listarPeliculas(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void listarPeliculas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PeliculaDAO pd = new PeliculaDAO();
        List<Pelicula> peliculas = pd.listarPeliculas();
        req.setAttribute("peliculas", peliculas);
        req.getRequestDispatcher("Pelicula/VerPeliculas.jsp").forward(req, resp);
    }

    private void borrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.valueOf(req.getParameter("id"));
       PeliculaDAO pd = new PeliculaDAO();
       pd.eliminarPelicula(new Pelicula(id));
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}

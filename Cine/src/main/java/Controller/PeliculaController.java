/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.PeliculaDAO;
import model.Entity.Pelicula;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {     
                case "registar":
                    this.registrar(req,resp);
                    this.listarPeliculas(req, resp);
                    break;    
                default:
                    this.listarPeliculas(req, resp);
            }
        } else {
            this.listarPeliculas(req, resp);
        }
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

    private void registrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*String nombre = req.getParameter("nombre");
        String genero = req.getParameter("genero");
        int duracion = Integer.valueOf(req.getParameter("duracion"));
        String director = req.getParameter("director");
        String clasificacion = req.getParameter("clasificacion");*/
        Pelicula p = new Pelicula();
        PeliculaDAO pd = new PeliculaDAO();
        
        try{
            ArrayList<String> lista = new ArrayList();
            FileItemFactory file = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(file);
            List items = fileUpload.parseRequest(req);
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);
                if(!fileItem.isFormField()){
                    File f = new File("C:\\AppServ\\www\\phpMyAdmin\\img\\"+fileItem.getName());
                    fileItem.write(f);
                    p.setCartelera("http://localhost/phpMyAdmin/img/"+fileItem.getName());
                }else{
                    lista.add(fileItem.getString());
                }
            }
            /*p.setNombre(nombre);
            p.setGenero(genero);
            p.setDuracion(duracion);
            p.setDirector(director);
            p.setClasificacion(clasificacion);
            p.setTrailer("falta");*/
            p.setNombre(lista.get(0));
            p.setGenero(lista.get(1));
            p.setDuracion(Integer.valueOf(lista.get(2)));
            p.setDirector(lista.get(3));
            p.setClasificacion(lista.get(4));
            p.setTrailer("falta");
            pd.insertar(p);
            
        }catch(Exception e){
            
        }
        
    }
}

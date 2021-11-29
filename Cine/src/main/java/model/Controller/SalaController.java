/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ConfiteriaDAO;
import model.DAO.SalaDAO;
import model.Entity.Confiteria;
import model.Entity.Sala;

/**
 *
 * @author USUARIO
 */
@WebServlet(" /sala ")
public class SalaController extends HttpServlet {
    protected void doGet(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException 
    {
        String accion =req.getParameter("accion");
        if(accion!= null){
            switch(accion){
                case "AgregarSala":
                    this.AgregarSala(req, resp);
                    break;
                    case "BorrarConfiteria":
                    this.BorrarSala(req, resp);
                    case "ActualizarConfiteria":
                      this.BorrarSala(req, resp);
                    default:
                    //this.ConsultarSala(req, resp);
                        this.BorrarSala(req, resp);
                        //this.BorrarSala(req, resp);
            }
           
    }
    }
    private void ConsultarSala(HttpServletRequest req, 
        HttpServletResponse resp) throws ServletException, IOException{
        SalaDAO cDao = new SalaDAO();
        List<Sala> confiterias = cDao.consultar();
        req.setAttribute("sala", confiterias);
        req.getRequestDispatcher("sala/versala.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException 
    {
        String accion =req.getParameter("accion");
        if(accion!= null){
            switch(accion){
                case "AgregarSala":
                    this.AgregarSala(req, resp);
                    break;
                
                case "BorrarSala":
                    this.BorrarSala(req, resp);
                    
                    default:
                    //this.ConsultarSala(req, resp);
                        this.BorrarSala(req, resp);
                    
            }
           
        }
        else{
            this.ConsultarSala(req, resp);
        }
    }

    private void AgregarSala(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cantidad_asientos = req.getParameter("cantidad_asientos");
      
        
        Sala sala = new Sala (cantidad_asientos);
        
        int registros = new SalaDAO().Insertar(sala);
        
        
        this.ConsultarSala(req, resp);
    }

    private void BorrarSala(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int registros =new SalaDAO().borrar(new Sala(id));
        this.ConsultarSala(req, resp);
    }
    
}

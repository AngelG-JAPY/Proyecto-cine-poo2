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
import model.DAO.ProgramacionDAO;
import model.Entity.Programacion;

/**
 *
 * @author USUARIO
 */
@WebServlet("/programaciones")
public class ProgramacionController extends HttpServlet {
    
    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                
            }
        }else{
            this.listarProgramaciones(req, resp);
        }
    }
    
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "registrar":
                    this.registrar(req,resp);
                    break;
                    
                default: 
                    this.listarProgramaciones(req, resp);
                    
            }
        }else{
            this.listarProgramaciones(req, resp);
        }
    }
    
    private void listarProgramaciones (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProgramacionDAO p = new ProgramacionDAO();
        List<Programacion> programacion = p.listarProgramacion();
        req.setAttribute("programacion", programacion);
        req.getRequestDispatcher("Programacion/VerProgramacion.jsp").forward(req, resp);   
    }

    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

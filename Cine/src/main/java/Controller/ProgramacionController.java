/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
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

    private void registrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Date inicio = Date.valueOf(req.getParameter("fecha-inicio"));
        Date fin = Date.valueOf(req.getParameter("fecha-fin"));       
        System.out.println(req.getParameter("fecha-inicio"));
        
        Programacion p = new Programacion(id, inicio, fin);
        ProgramacionDAO pd = new ProgramacionDAO();
        
        pd.insertarProgramacion(p);
        this.listarProgramaciones(req, resp);
    }
    
}

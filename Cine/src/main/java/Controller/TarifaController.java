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
import model.DAO.TarifaDAO;
import model.Entity.Tarifa;

/**
 *
 * @author USUARIO
 */
@WebServlet("/tarifas")
public class TarifaController extends HttpServlet{
    
    public void listarTarifas (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        TarifaDAO t = new TarifaDAO();
        List<Tarifa> tarifas = t.listarTarifa();
        req.setAttribute("tarifa", tarifas);
        req.getRequestDispatcher("Tarifa/verTarifas.jsp").forward(req, resp);
    }
    
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listarTarifas(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "registrar":
                    this.insertar(req, resp);
                    break;
                    
                default:
                    this.listarTarifas(req, resp);
            }
        }else{
            this.listarTarifas(req, resp);
        }
    }

    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String dia = req.getParameter("dia");
        String precio = req.getParameter("precio");
        
        Tarifa t = new Tarifa(Integer.valueOf(precio), dia);
        TarifaDAO td = new TarifaDAO();
        td.insertar(t);
        this.listarTarifas(req, resp);
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.DAO.MembresiaDAO;
import model.DAO.ReservaDAO;
import model.DAO.UsuarioDAO;
import model.Entity.Confiteria;
import model.Entity.Funcion;
import model.Entity.Membresia;
import model.Entity.Reserva;
import model.Entity.Usuario;

/**
 *
 * @author javie
 */
public class Test {
    
    public static void main(String[] args) {
        
        MembresiaDAO m = new MembresiaDAO();
        
        List<Membresia> membresias = new ArrayList();
        
        membresias = m.consultar();
       
        for (int i=0; i<membresias.size(); i++){
            System.out.println("nombre mem = "+membresias.get(i).getNombre());
        }
        
        UsuarioDAO u = new UsuarioDAO();
        //u.insertar(new Usuario(1, "Javier", "M", "javier.com", 44566, 31162935, new Membresia(3)));
        List<Usuario> us = new ArrayList();
        us = u.consultar();
        for (int i=0; i<us.size(); i++){
            System.out.println("nombre us = "+us.get(i).getNombre());
        }
        
        ReservaDAO r = new ReservaDAO();
        //r.insertar(new Reserva(1, new Funcion(1), new Usuario(1), new Confiteria(1), new Date(11-10-2021), new Date(11/10/2021), 100, 2));
        
        
        
        
    }
    
}

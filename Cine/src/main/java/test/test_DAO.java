/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.DAO.ConfiteriaDAO;
import model.DAO.MembresiaDAO;
import model.DAO.ReservaDAO;
import model.DAO.SalaDAO;
import model.DAO.UsuarioDAO;
import model.Entity.Confiteria;
import model.Entity.Funcion;
import model.Entity.Membresia;
import model.Entity.Reserva;
import model.Entity.Sala;
import model.Entity.Usuario;

/**
 *
 * @author BunnyMoon
 */
public class test_DAO {

    public static void main(String[] args) {

        UsuarioDAO us = new UsuarioDAO();
        //us.insertar(new Usuario("MathiasGOD", 123, "G", "mathiashc@ufps.edu.co", 1266, new Membresia(1), "sumama"));
        //us.borrar(new Usuario("MathiasGOD", 123, "G", "mathiashc@ufps.edu.co", 1266, new Membresia(1), "sumama"));
        List<Usuario> usuarios = new ArrayList();
        
        usuarios = us.consultar();
        
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("nombre = " + usuarios.get(i));
        }

        MembresiaDAO m = new MembresiaDAO();
        //m.insertar(new Membresia(2, "Plata", 12000));
        //m.borrar(new Membresia(2, "Plata", 12000));
        List<Membresia> membresias = new ArrayList();
        
        membresias = m.consultar();
        
        for (int i = 0; i < membresias.size(); i++) {
            System.out.println("nombre = " + membresias.get(i));
        }

        ReservaDAO r = new ReservaDAO();
        //r.insertar(new Reserva(2, new Funcion(1), new Usuario(1), new Confiteria(1), new Date(1 / 10 / 2021), new Date(1 / 10 / 2021), 10000, 3));
        //r.borrar(new Reserva(2, new Funcion(1), new Usuario(1), new Confiteria(1), new Date(1/10/2021), new Date(1/10/2021), 10000, 3));
        List<Reserva> reservas = new ArrayList();

        reservas = r.consultar();

        for (int i = 0; i < reservas.size(); i++) {
            System.out.println("nombre = " + reservas.get(i));
        }

        
        SalaDAO s = new SalaDAO();
        //s.Insertar(new Sala(30));
        //s.borrar(new Sala(2, 30));
        //s.actualizar(new Sala(3, 50));
        
        List<Sala> salas = s.consultar();
        System.out.println(salas.toString());
        
        ConfiteriaDAO c = new ConfiteriaDAO();
        //c.Insertar(new Confiteria(1, "hamburguesa", 5000, 1));
        //c.borrar(new Confiteria(1, "hamburguesa", 5000, 1));
        //c.actualizar(new Confiteria(1, "hamburguesa", 6000, 1));
        
        List<Confiteria> conf = c.consultar();
        System.out.println(conf.toString());
        
        
        
    }

}

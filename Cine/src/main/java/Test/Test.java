/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import java.util.List;
import model.DAO.ConfiteriaDAO;
import model.Entity.Confiteria;

/**
 * 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
 * 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
 * @author USUARIO
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //SalaDAO s = new SalaDAO();
       //s.Insertar(new Sala(30));
       //s.borrar(new Sala(2,30));
       //s.actualizar(new Sala(3,50));
       //List<Sala> salas = s.consultar();
       //System.out.println(salas.toString());
       ConfiteriaDAO c = new ConfiteriaDAO();
       //c.Insertar(new Confiteria(1,"hamburguesa",5000,1));
       //c.Insertar(new Confiteria(2,"Palomitas owo",10000,1));
       //c.borrar(new Confiteria(1,"hamburguesa",5000,1));
       c.actualizar(new Confiteria(1,"hamburguesa",6000,1));
       
       List<Confiteria> conf =c.consultar();
       System.out.println(conf.toString());
    }
    
}

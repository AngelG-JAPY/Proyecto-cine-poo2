
import java.util.List;
import model.DAO.FuncionDAO;
import model.Entity.Funcion;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Pelicula p = new Pelicula(120, "Spider-Man 2", "Accion", "Sam Raimi", "+15", "falta", "falta");
//        p.setId(1);
//        PeliculaDAO pDao =  new PeliculaDAO();
//
//        pDao.actualizarPelicula(p);
        
        //pDao.insertar(p);
        
        FuncionDAO f = new FuncionDAO();
        
        List<Funcion> funciones = f.listarFunciones();
        
        for(Funcion ff: funciones){
            System.out.println(ff.toString());
        }
    }
    
}

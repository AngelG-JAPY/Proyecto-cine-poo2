
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UsuarioDAO;
import model.Entity.Membresia;
import model.Entity.Usuario;


@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet{
    private void listarUsuarios (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UsuarioDAO ud = new UsuarioDAO();
        List<Usuario> usuarios = ud.consultar();
        req.setAttribute("usuario", usuarios);
        req.getRequestDispatcher("usuario/verus.jsp").forward(req, resp);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "eliminar":
                    this.eliminar(req, resp);
                    break;
                    
                case "editar":
                    this.editar(req, resp);
                    break;
                    
                default:
                    this.listarUsuarios(req, resp);
            }
        }else{
            this.listarUsuarios(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertar(req, resp);
                    break;
                case "modificar":
                    this.modificar(req,resp);
                    break;
                default:
                    this.listarUsuarios(req, resp);
            }
        }else{
            this.listarUsuarios(req, resp);
        }
    }

    private void insertar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id_usuario = Integer.valueOf(req.getParameter("documento"));
        String nombre = req.getParameter("nombre");
        String genero = req.getParameter("genero");
        String email = req.getParameter("email");
        int contraseña = Integer.valueOf(req.getParameter("contraseña"));
        int telefono = Integer.valueOf(req.getParameter("telefono"));
        Membresia membresia = new Membresia(Integer.valueOf(req.getParameter("id")));
        Usuario u = new Usuario(id_usuario, nombre, genero, email, contraseña, telefono, membresia);
        UsuarioDAO ud = new UsuarioDAO();
        ud.insertar(u);
        this.listarUsuarios(req, resp);
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String idUs = req.getParameter("id");
       
       UsuarioDAO  ud = new UsuarioDAO();
       System.out.println(idUs);
       ud.borrar(new Usuario(Integer.valueOf(idUs)));
       this.listarUsuarios(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String idUs = req.getParameter("id");
        Usuario usuarios = new UsuarioDAO().consultarPorID(new Usuario(Integer.valueOf(idUs)));
        req.setAttribute("usuario", usuarios);
        req.getRequestDispatcher("usuario/verus.jsp").forward(req, resp);
    }

    private void modificar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        int id_usuario = Integer.valueOf(req.getParameter("documento"));
        String genero = req.getParameter("genero");
        String email = req.getParameter("email");
        int contraseña = Integer.valueOf(req.getParameter("contraseña"));
        int telefono = Integer.valueOf(req.getParameter("telefono"));
        Membresia membresia = new Membresia(Integer.valueOf(req.getParameter("id")), req.getParameter("nombre"), Integer.valueOf(req.getParameter("precio")));
        UsuarioDAO ud = new UsuarioDAO();
        Usuario u = new Usuario(id_usuario, nombre, genero, email, contraseña, telefono, membresia);
        ud.actualizar(u);
        this.listarUsuarios(req, resp);
    }
}


package model.Entity;


public class Usuario {
    private String nombre;
    private int id_usuario;
    private String genero;
    private String email;
    private int telefono;
    private String id_membresia;
    private String contraseña;

    public Usuario(String nombre, int id_usuario, String genero, String email, int telefono, String id_membresia, String contraseña) {
        this.nombre = nombre;
        this.id_usuario = id_usuario;
        this.genero = genero;
        this.email = email;
        this.telefono = telefono;
        this.id_membresia = id_membresia;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(String id_membresia) {
        this.id_membresia = id_membresia;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
}

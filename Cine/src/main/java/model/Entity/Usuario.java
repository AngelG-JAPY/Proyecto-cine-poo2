
package model.Entity;


public class Usuario {
    private String nombre;
    private int id_usuario;
    private String genero;
    private String email;
    private int telefono;
    private Membresia membresia;
    private int contraseña;

    public Usuario(int id_usuario, String nombre, String genero, String email, int contraseña, int telefono, Membresia membresia) {
        this.nombre = nombre;
        this.id_usuario = id_usuario;
        this.genero = genero;
        this.email = email;
        this.telefono = telefono;
        this.membresia = membresia;
        this.contraseña = contraseña;
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", id_usuario=" + id_usuario + ", genero=" + genero + ", email=" + email + ", telefono=" + telefono + ", membresia=" + membresia + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
    
}

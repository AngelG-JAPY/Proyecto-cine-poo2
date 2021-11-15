
package model.Entity;


public class Membresia {
    private int id_membresia;
    private String nombre;
    private int valor;

    public Membresia(int id_membresia, String nombre, int valor) {
        this.id_membresia = id_membresia;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Membresia() {
    }

    public int getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}

package model.Entity;

public class Membresia {

    private int id;
    private String nombre;
    private int valor;

    public Membresia(int id, String nombre, int valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Membresia(int id) {
        this.id = id;
    }

    public Membresia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Membresia{" + "id_membresia=" + id + ", nombre=" + nombre + ", valor=" + valor + '}';
    }

}

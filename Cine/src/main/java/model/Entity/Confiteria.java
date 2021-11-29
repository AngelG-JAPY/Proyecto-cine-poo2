/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author USUARIO
 */
public class Confiteria {
    private String Nombre;
    private int Id;
    private int Precio;
    private int Cantidad;

    public Confiteria() {
    }

    public Confiteria( int Id, String Nombre, int Precio, int Cantidad) {
        this.Nombre = Nombre;
        this.Id = Id;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
    }

    public Confiteria(String nombre, String id, String precio, String cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Confiteria(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getId() {
        return Id;
    }

    public int getPrecio() {
        return Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    @Override
    public String toString() {
        return "Confiteria{" + "Nombre=" + Nombre + ", Id=" + Id + ", Precio=" + Precio + ", Cantidad=" + Cantidad + '}';
    }

    
    
}

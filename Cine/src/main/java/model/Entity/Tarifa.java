/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author javie
 */
public class Tarifa {
    private int idTarifa;
    private int precio;
    private String nombre;
    
    public Tarifa(){
        
    }

    public Tarifa(int id_tarifa, int precio, String nombre) {
        this.idTarifa = id_tarifa;
        this.precio = precio;
        this.nombre = nombre;
    }
    
    public Tarifa( int precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }
    
    public Tarifa(int id){
        this.idTarifa = id;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "idTarifa=" + idTarifa + ", precio=" + precio + ", nombre=" + nombre + '}';
    }
}

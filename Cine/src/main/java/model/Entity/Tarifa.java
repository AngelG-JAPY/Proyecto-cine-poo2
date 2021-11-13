/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;


/**
 *
 * @author USUARIO
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

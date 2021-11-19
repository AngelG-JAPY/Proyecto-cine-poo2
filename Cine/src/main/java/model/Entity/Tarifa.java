/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author USUARIO
 */
public class Tarifa {
    private int precio;
    private String nombre;
    private int idTarifa;
    private String rebaja;

    public Tarifa() {
    }

    public Tarifa(int precio, String nombre, String rebaja, int idTarifa) {
        this.precio = precio;
        this.nombre = nombre;
        this.rebaja = rebaja;
        this.idTarifa = idTarifa;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRebaja() {
        return rebaja;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRebaja(String rebaja) {
        this.rebaja = rebaja;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "precio=" + precio + ", nombre=" + nombre + ",rebaja " + rebaja + ", idTarifa=" + idTarifa + '}';
    }

   
    
}

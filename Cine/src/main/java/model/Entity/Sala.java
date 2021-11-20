/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author USUARIO
 */
public class Sala {
   private int id;
   private int cantidad_asientos;

    public Sala(int cantidad_asientos) {
        
        this.cantidad_asientos = cantidad_asientos;
    }

    public Sala() {
    }

    public Sala(int id, int cantidad_asientos) {
        this.id = id;
        this.cantidad_asientos = cantidad_asientos;
    }
    
    
    public int getId() {
        return id;
    }

    public int getCantidad_asientos() {
        return cantidad_asientos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad_asientos(int cantidad_asientos) {
        this.cantidad_asientos = cantidad_asientos;
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", cantidad_asientos=" + cantidad_asientos + '}';
    }

   
   
   
   
   
   
   
}

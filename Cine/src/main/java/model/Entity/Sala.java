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
   private String Id;
   private int Asientos;

    public Sala() {
    }

    public Sala(String Id, int Asientos) {
        this.Id = Id;
        this.Asientos = Asientos;
    }

    public String getId() {
        return Id;
    }

    public int getAsientos() {
        return Asientos;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setAsientos(int Asientos) {
        this.Asientos = Asientos;
    }

    @Override
    public String toString() {
        return "Sala{" + "Id=" + Id + ", Asientos=" + Asientos + '}';
    }
   
}

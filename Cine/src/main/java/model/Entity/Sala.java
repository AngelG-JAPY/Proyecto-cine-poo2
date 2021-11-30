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

    public Sala(String cantidad_asientos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

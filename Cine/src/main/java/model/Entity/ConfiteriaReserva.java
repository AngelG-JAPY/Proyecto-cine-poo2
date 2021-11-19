/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author USUARIO
 */
public class ConfiteriaReserva {
    private Confiteria comida;
    
    private int IdComidaReserva;

    public ConfiteriaReserva() {
    }

    public ConfiteriaReserva(Confiteria comida, int IdComidaReserva) {
        this.comida = comida;
        
        this.IdComidaReserva = IdComidaReserva;
    }

    public Confiteria getComida() {
        return comida;
    }

    

    public int getIdComidaReserva() {
        return IdComidaReserva;
    }

    public void setComida(Confiteria comida) {
        this.comida = comida;
    }

   
    public void setIdComidaReserva(int IdComidaReserva) {
        this.IdComidaReserva = IdComidaReserva;
    }

    @Override
    public String toString() {
        return "ConfiteriaReserva{" + "comida=" + comida + ", IdComidaReserva=" + IdComidaReserva + '}';
    }
    
    
}

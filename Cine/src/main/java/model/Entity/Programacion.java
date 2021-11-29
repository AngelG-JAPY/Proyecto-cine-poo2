/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

import java.util.Date;

/**
 *
 * @author javie
 */
public class Programacion {
     private int idProgramacion;
    private Date fechaInicio;
    private Date fechaFin;
    
    public Programacion(){
        
    }
    
    public Programacion(int id){
        this.idProgramacion = id;
    }

    public Programacion(int idProgramacion, Date fechaInicio, Date fechaFin) {
        this.idProgramacion = idProgramacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(int idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

   

    @Override
    public String toString() {
        return "Programacion{" + "idProgramacion=" + idProgramacion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entity;

import java.util.Date;

/**
 *
 * @author USUARIO
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

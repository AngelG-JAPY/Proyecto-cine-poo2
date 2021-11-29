/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author javie
 */
public class Funcion {
    private int id;
    private Pelicula pelicula;
    private int idSala;
    private String horaInicio;
    private int diaSemana;
    private Programacion programacion;
    private Tarifa tarifa;
    
    public Funcion(){
        
    }

    public Funcion(int id, Pelicula pelicula, int idSala, String horaInicio, int diaSemana, Programacion programacion, Tarifa tarifa) {
        this.id = id;
        this.pelicula = pelicula;
        this.idSala = idSala;
        this.horaInicio = horaInicio;
        this.diaSemana = diaSemana;
        this.programacion = programacion;
        this.tarifa = tarifa;
    }

    public Funcion(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "id: " + id + ", pelicula: " + pelicula.getNombre() + ", idSala: " + idSala + ", horaInicio: " + horaInicio + ", diaSemana: " + diaSemana 
                + "\n programacion: " + programacion.getIdProgramacion() +", fecha_Inicio: " + programacion.getFechaInicio()+", fecha_fin: " + programacion.getFechaFin()
                + "\n tarifa: " + tarifa.toString();
    }
    
    

}

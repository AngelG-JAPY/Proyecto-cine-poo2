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
public class Pelicula {
    private int id;
    private int duracion;
    private String nombre;
    private String genero;
    private String director;
    private String clasificacion;
    private String cartelera;
    private String trailer;

    public Pelicula() {
    }

    public Pelicula(int id, int duracion, String nombre, String genero, String director, String clasificacion, String cartelera, String trailer) {
        this.id = id;
        this.duracion = duracion;
        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        this.clasificacion = clasificacion;
        this.cartelera = cartelera;
        this.trailer = trailer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCartelera() {
        return cartelera;
    }

    public void setCartelera(String cartelera) {
        this.cartelera = cartelera;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", duracion=" + duracion + ", nombre=" + nombre + ", genero=" + genero + '}';
    }
    
    
}

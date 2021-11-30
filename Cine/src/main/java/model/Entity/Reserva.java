
package model.Entity;

import java.util.Date;


public class Reserva {
    private int id_reserva;
    private Funcion id_funcion;
    private Confiteria id_comida;
    private Usuario id_usuario;
    private Date fecha_funcion;
    private Date fecha_reserva;
    private int precio_reserva;
    private int cantidad_sillas;

    public Reserva(int id_reserva, Funcion id_funcion, Usuario id_usuario, Confiteria id_comida, Date fecha_funcion, Date fecha_reserva, int precio_reserva, int cantidad_sillas) {
        this.id_reserva = id_reserva;
        this.id_funcion = id_funcion;
        this.id_comida = id_comida;
        this.id_usuario = id_usuario;
        this.fecha_funcion = fecha_funcion;
        this.fecha_reserva = fecha_reserva;
        this.precio_reserva = precio_reserva;
        this.cantidad_sillas = cantidad_sillas;
    }

    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Reserva() {
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Funcion getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(Funcion id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Confiteria getId_comida() {
        return id_comida;
    }

    public void setId_comida(Confiteria id_comida) {
        this.id_comida = id_comida;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(Date fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public int getPrecio_reserva() {
        return precio_reserva;
    }

    public void setPrecio_reserva(int precio_reserva) {
        this.precio_reserva = precio_reserva;
    }

    public int getCantidad_sillas() {
        return cantidad_sillas;
    }

    public void setCantidad_sillas(int cantidad_sillas) {
        this.cantidad_sillas = cantidad_sillas;
    }

    

    @Override
    public String toString() {
        return "Reserva{" + "id_reserva=" + id_reserva + ", id_funcion=" + id_funcion + ", id_comida=" + id_comida + ", id_usuario=" + id_usuario + ", fecha_funcion=" + fecha_funcion + ", fecha_reserva=" + fecha_reserva + ", precio_reserva=" + precio_reserva + ", cantidad_sillas=" + cantidad_sillas + '}';
    }

    
    
    
    
    
            
    
}

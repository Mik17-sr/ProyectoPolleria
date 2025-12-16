package com.mycompany.model;

import java.util.Date;

/**
 *
 * @author Miguel
 */
public abstract class Transaccion {
    protected int id;
    protected double precio;
    protected Date fecha;

    public Transaccion(int id, double precio, Date fecha) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Transaccion() {
        this.id = 0;
        this.precio = 0;
        this.fecha = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nPrecio: " + precio + "\nFecha: " + fecha;
    }    
}

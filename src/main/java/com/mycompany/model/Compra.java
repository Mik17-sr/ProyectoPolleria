package com.mycompany.model;

import java.util.Date;

public class Compra extends Transaccion{
    private Proveedor proveedor;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Compra() {
        super();
        this.proveedor = new Proveedor();
    }

    public Compra(Proveedor proveedor, int id, double precio, Date fecha,String observacion) {
        super(id, precio, fecha);
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Compra: " + super.toString() + "\nProveedor"+ proveedor;
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
    
    
    
    
}

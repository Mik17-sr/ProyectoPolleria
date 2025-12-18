package com.mycompany.model;

import java.util.Date;

public class Venta extends Transaccion {
    private Cliente cliente;
    private String observacion;

    public Venta() {
        super();
        this.cliente = new Cliente();
    }

    public Venta(Cliente cliente, int id, double precio, Date fecha) {
        super(id, precio, fecha);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    @Override
    public String toString() {
        return "Venta:" + super.toString() + "\nCliente: " +  cliente;
    }   
}

package com.mycompany.model;

import java.util.Date;

public class Compra extends Transaccion{
    private Proveedor proveedor;

    public Compra() {
        super();
        this.proveedor = new Proveedor();
    }

    public Compra(Proveedor proveedor, int id, double precio, Date fecha) {
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
    
    
    
    
}

package com.mycompany.model;

public class Proveedor extends Persona {
    private int idproveedor;

    public Proveedor() {
        super();
        this.idproveedor = 0;
    }

    public Proveedor(int idproveedor, String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
        this.idproveedor = idproveedor;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public String toString() {
        return "Proveedor\n ID proveedor: " + idproveedor + super.toString();
    }
}

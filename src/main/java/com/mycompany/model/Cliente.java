package com.mycompany.model;

public class Cliente extends Persona {
    private int idCliente;

    public Cliente() {
        super();
        this.idCliente = 0;
    }

    public Cliente(int idCliente, String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente\nID Cliente: " + idCliente + super.toString();
    }
}

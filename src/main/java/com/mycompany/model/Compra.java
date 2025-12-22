package com.mycompany.model;
import com.mycompany.model.Proveedor;
import com.mycompany.model.Transaccion;
import java.util.Date;

public class Compra extends Transaccion {

    private Proveedor proveedor;
    private String observacion;

    public Compra() {
        super();
        this.proveedor = new Proveedor();
    }

    public Compra(Proveedor proveedor, int id, double precio, Date fecha, String observacion) {
        super(id, precio, fecha);
        this.proveedor = proveedor;
        this.observacion = observacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

  
}

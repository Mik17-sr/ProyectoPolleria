package com.mycompany.model;

import java.util.Date;

public class Pago {
    private int idPago;
    private double monto;
    private Date fechaPago;
    private String metodoPago;
    private String observaciones;
    private Venta venta;

    public Pago() {
        this.idPago = 0;
        this.monto = 0;
        this.fechaPago = new Date();
        this.metodoPago = "";
        this.observaciones = "";
        this.venta = new Venta();
    }

    public Pago(int idPago, double monto, Date fechaPago, String metodoPago, String observaciones, Venta venta) {
        this.idPago = idPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.observaciones = observaciones;
        this.venta = venta;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Pago: " + idPago + "\nMonto: " + monto + "\nFecha Pago: " + fechaPago + "\nMetodo de Pago: " + metodoPago + "\nObservaciones: " + observaciones + "\nVenta: " + venta + '}';
    }   
}

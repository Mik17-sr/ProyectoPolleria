package com.mycompany.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Venta extends Transaccion {
    private Cliente cliente;
    private String observacion;
    private ArrayList<Pago> pagos;

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

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }
    
    public double calcularMontoPagos(){
        double montoTotal = 0;
        for(Pago p : pagos){
            montoTotal += p.getMonto();
        }
        return montoTotal;
    }
    
    public boolean validarMontoPago(){
        return calcularMontoPagos() ==  precio;
    }
    public  void setIdVenta(int id){
        this.id=id;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
            formatoCOP.setMaximumFractionDigits(0);
        return "Cliente: " + cliente.getNombre() + " por Monto: " + formatoCOP.format(precio) + " realizado el " + sdf.format(fecha);
    }   
}

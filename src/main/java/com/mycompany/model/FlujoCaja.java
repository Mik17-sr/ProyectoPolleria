package com.mycompany.model;

public class FlujoCaja {
    private String fecha;
    private double cobros;
    private double pagos;
    
    public FlujoCaja(){
        this.fecha = "";
        this.cobros = 0;
        this.pagos = 0;
    }

    public FlujoCaja(String fecha, double cobros, double pagos) {
        this.fecha = fecha;
        this.cobros = cobros;
        this.pagos = pagos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCobros() {
        return cobros;
    }

    public void setCobros(double cobros) {
        this.cobros = cobros;
    }

    public double getPagos() {
        return pagos;
    }

    public void setPagos(double pagos) {
        this.pagos = pagos;
    }         
}

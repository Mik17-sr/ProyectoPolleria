package com.mycompany.Utility;

import java.time.LocalDate;

public class RangoFecha {
    private LocalDate inicio;
    private LocalDate fin;

    public RangoFecha(LocalDate inicio, LocalDate fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public String getInicioSQL() {
        return inicio.toString(); 
    }

    public String getFinSQL() {
        return fin.toString();
    }
}